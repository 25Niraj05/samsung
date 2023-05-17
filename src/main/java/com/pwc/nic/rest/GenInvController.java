package com.pwc.nic.rest;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsoniter.JsonIterator;
import com.jsoniter.output.JsonStream;
import com.pwc.nic.enums.SubSupplyTypes;
import com.pwc.nic.enums.SupplyType;
import com.pwc.nic.enums.TransactionType;
import com.pwc.nic.model.EwbDetails;
import com.pwc.nic.model.GSTINMasterEntity;
import com.pwc.nic.repository.AuthTokenRepository;
import com.pwc.nic.services.*;
import com.pwc.nic.util.*;
import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;

import static com.pwc.nic.util.Constants.*;

@RestController
//@RequestMapping(value = "/v1")
public class GenInvController {

    private static final Logger logger = LoggerFactory.getLogger(GenInvController.class);

    @Autowired
    private Environment env;

    @Autowired
    private AuthenticationService authService;

    @Autowired
    EwbDetailService ewbDetailsService;

    @Autowired
    SaveDataToUploadTableService saveDataToUploadTableService;

    @Autowired
    Utils util;

    @Autowired
    GSTINMasterService gstinMasterService;

    @Autowired
    private GenerateService genService;

    @Autowired
    private AuthTokenRepository redisRepo;

    @Autowired
    GenerateEWBService generateEWBService;

    @Autowired
    ProcessPayloadService processPayloadService;

    @Autowired
    GetEwayBillService getEwayBillService;

    @PostMapping(value = "/hello-world")
    String test() {
        logger.info("in test function");
        return "OK";

    }

    private @ResponseBody
    ResponseEntity<?> generateProcess(Integer customerid, String token, String username, String password,
                                      String isLive,
                                      String body) {
        ApiResponse response = new ApiResponse();
        String gstin = EMPTY_STRING;

        boolean saveEwbData = Boolean.parseBoolean(env.getProperty(SAVE_ED));
        String bu = EMPTY_STRING;
        String sbu = EMPTY_STRING;
        String location = EMPTY_STRING;
        boolean viaIRN = false;

        try {
            JSONObject jsonBody = new JSONObject(body);
            JSONObject docDtls = jsonBody.getJSONObject(DOC_DTLS);

            if (new JSONObject(body).has(MIS_COLUMNS)) {
                JSONObject misColumns = new JSONObject(body).getJSONObject(MIS_COLUMNS);
                bu = misColumns.getString(BU);
                sbu = misColumns.getString(SBU);
                location = misColumns.getString(LOCATION);
            }

            logger.info("Request Payload is:{}", new JSONObject(body));

            if (!jsonBody.has(IS_IRN) && !jsonBody.has(IS_EWB)){
                viaIRN = true;
            } else if (jsonBody.has(IS_IRN) && Y.equalsIgnoreCase(jsonBody.getString(IS_IRN))){
                if (jsonBody.has(IS_EWB) && N.equalsIgnoreCase(jsonBody.getString(IS_EWB))){
                    viaIRN = true;
                    if (jsonBody.has(EWB_DTLS)){
                        jsonBody.remove(EWB_DTLS);
                        body = jsonBody.toString();
                    }
                } else {
                    viaIRN = true;
                }
            } else if (jsonBody.has(IS_IRN) && N.equalsIgnoreCase(jsonBody.getString(IS_IRN))) {
                if (jsonBody.has(IS_EWB) && Y.equalsIgnoreCase(jsonBody.getString(IS_EWB))){
                    logger.info("generate only EWB using flow that is already implemented internally)");
                } else {
                    createSchemaSkipResponse(response, "gstin", docDtls);
                    return new ResponseEntity<>(response, HttpStatus.OK);
                }
            } else if (N.equalsIgnoreCase(jsonBody.getString(IS_EWB))){
                viaIRN = true;
                if (jsonBody.has(EWB_DTLS)){
                    jsonBody.remove(EWB_DTLS);
                    body = jsonBody.toString();
                }
            }

            JSONObject json1 = new JSONObject(body);
            JSONObject object = transferJsonKey(json1);
            logger.info("Request object after transformation is:{}", object);

            gstin = new JSONObject(body).getString(USER_GSTIN);
            GSTINMasterEntity gs = null;
            String uName;
            String pass;
            logger.info("Req_Header UserName : {}", username);
            logger.info("Req_Header password : {}", password);
            if ((username != null) && (password != null)) {
                logger.info("Request Header contains UserName & Password");
                uName = username;
                pass = password;
            } else if ((null == username) && (null == password)) {
                logger.info("..Check database for GSTIN  : {}", gstin);
                gs = gstinMasterService.getGSTINMaster(gstin);
                logger.info("gsentity is :{}", new ObjectMapper().writeValueAsString(gs));
                if (null == gs) {
                    response.setError(true);
                    response.setStatus(Constants.PwC_AUTH_FAILED);
                    response.setMessage(PWC_AUTH_FAILED);
                    JSONArray arrayErrors = new JSONArray();
                    JSONObject errors = new JSONObject();
                    errors.put(MESSAGE, "GSTIN Configurations are Missing");
                    arrayErrors.put(0, errors);
                    errors = new JSONObject();
                    errors.put(ERROR_DETAILS, arrayErrors);
                    response.setData(JsonIterator.deserialize(errors.toString(), Object.class));
                    logger.info("Either GSTIN :{} credentials are unavailable", gstin);
                    return new ResponseEntity<>(response, HttpStatus.OK);
                }

                uName = gs.getIrnUserName();
                pass = Encryption.decrypt(gs.getIrnPassword());
            } else {
                logger.info(MISSING_UNAME_OR_PWD);
                response.setError(true);
                response.setStatus(Constants.NIC_AUTH_FAILED);
                response.setMessage(PWC_AUTH_FAILED);
                JSONArray arrayErrors = new JSONArray();
                JSONObject errors = new JSONObject();
                errors.put(MESSAGE, MISSING_UNAME_OR_PWD);
                arrayErrors.put(0, errors);
                errors = new JSONObject();
                errors.put(ERROR_DETAILS, arrayErrors);
                response.setData(JsonIterator.deserialize(errors.toString(), Object.class));
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            logger.info("gstinentity is: {}", new ObjectMapper().writeValueAsString(gs));
            logger.info("EInvoice-Authentication process start gstin : {}", gstin);
            final ApiResponse authRes = authService.authenticate(gstin, uName.trim(), pass.trim(), customerid, isLive);
            // Awanish changes start
            logger.info(AUTH_END_MESSAGE, gstin, JsonStream.serialize(authRes));
            if (authRes.isError() && null != authRes.getStatus() && authRes.getStatus().equalsIgnoreCase("0")) {
                logger.info("EInvoice NIC authenticate Services are unavailable");
                authRes.setError(true);
                authRes.setMessage("IRN Schema Validation Passed, Response not Received ");
                authRes.setStatus(Constants.NIC_AUTH_FAILED);
                JSONArray arrayErrors = new JSONArray();
                JSONObject errors = new JSONObject();
                try {
                    errors.put(MESSAGE,
                        "EInvoice NIC Services authenticate is not available, please try after sometime");
                    arrayErrors.put(0, errors);
                    errors = new JSONObject();
                    errors.put(ERROR_DETAILS, arrayErrors);
                    authRes.setData(JsonIterator.deserialize(errors.toString(), Object.class));
                } catch (JSONException ex) {
                    logger.error(JSON_EX_MESSAGE, ex);
                }
                return new ResponseEntity<>(authRes, HttpStatus.SERVICE_UNAVAILABLE);
            }

            // Awanish changes end
            logger.info(AUTH_END_MESSAGE, gstin, JsonStream.serialize(authRes));
            if (authRes.isError()) {
                authRes.setError(true);
                authRes.setStatus(Constants.NIC_AUTH_FAILED);
                authRes.setMessage(NIC_AUTH_FAILED_MESSAGE);
                JSONArray arrayErrors = new JSONArray();
                arrayErrors.put(0, new JSONObject(authRes.getData().toString()).optJSONObject(Constants.ERROR_DETAILS));
                JSONObject errors = new JSONObject();
                errors.put(ERROR_DETAILS, arrayErrors);
                authRes.setData(JsonIterator.deserialize(errors.toString(), Object.class));
                return new ResponseEntity<>(authRes, HttpStatus.OK);
            }
            logger.info("EInvoice-Generate process start for  gstin : {}", gstin);

            JSONObject transDtls = jsonBody.getJSONObject(TRAN_DTLS);
            JSONObject sellerDtls = jsonBody.getJSONObject(SELLER_DTLS);
            JSONObject buyerDtls = jsonBody.getJSONObject(BUYER_DTLS);
            JSONObject valDtls = null;
            JSONObject shipDtls = null;
            JSONArray itemListArray = jsonBody.getJSONArray(ITEM_LIST_REQ);
            JSONArray itemList = new JSONArray();
            for (int i = 0; i < itemListArray.length(); i++) {
                JSONObject item = itemListArray.getJSONObject(i);
                itemList.put(i, processPayloadService.setItemDetails(item));
            }
            if (jsonBody.has(VAL_DTLS)) {
                valDtls = jsonBody.getJSONObject(VAL_DTLS);
            }

            JSONObject ewbDtls = new JSONObject();
            if (jsonBody.has(EWB_DTLS)) {
                ewbDtls = jsonBody.getJSONObject(EWB_DTLS);
            }

            String supplyType = null;
            if (transDtls.has(OUTWARD_INWARD)) {
                supplyType = transDtls.getString(OUTWARD_INWARD);
            }
            supplyType = StringUtils.isEmpty(supplyType)?OUTWARD:supplyType;
            String typeAcronym = EMPTY_STRING;
            for (SupplyType eachType : SupplyType.values()) {
                if (supplyType.equalsIgnoreCase(eachType.type)) {
                    typeAcronym = eachType.typeAcronym;
                    break;
                }
            }

            EwbDetails ewbDetails = new EwbDetails();
            String udId = gstin + COLON + docDtls.getString(NO) + COLON + supplyType;
            ewbDetails.setUdid(udId);
            ewbDetails.setUserGstin(gstin);
            ewbDetails.setDocNo(docDtls.getString(NO));


            String subType = null;
            if (transDtls.has(SUB_TYPE)) {
                subType = transDtls.getString(SUB_TYPE);
            }
            subType = StringUtils.isEmpty(subType)?SUPPLY:subType;
            String subSupplyType = null;
            for (SubSupplyTypes eachType : SubSupplyTypes.values()) {
                if (subType.equalsIgnoreCase(eachType.type)) {
                    subSupplyType = SubSupplyTypes.valueOf(String.valueOf(eachType)).typeNumber + EMPTY_STRING;
                    break;
                }
            }

            if (transDtls.has(SUP_TYPE) &&
                Constants.supplyTypesForIrn.contains(transDtls.getString(SUP_TYPE).toUpperCase()) &&
                Constants.documentTypesForIrn.contains(docDtls.getString(TYP).toUpperCase()) && viaIRN) {
                JSONObject jsonSchema = new JSONObject(Constants.GEN_INV_PAYLOAD);
                logger.info("Validating IRN-Gen Schema");
                Schema schema = SchemaLoader.load(jsonSchema);
                schema.validate(object);
                logger.info("Validated IRN-Gen Schema");

                JSONObject genEInvMap = null;
                for (int i = 0; i < 2; i++) {
                    try {
                        logger.info("Call EInvoice-Generate process NIC Services at count number is : {} ", i);
                        genEInvMap =
                            genService.generateEInvoice(new JSONObject(JsonStream.serialize(authRes.getData())),
                                object, gstin);
                        break;
                    } catch (ResourceAccessException e) {
                        Thread.sleep(30000);
                        logger.info("Call EInvoice-Generate process NIC service after 30 second: ", e);

                    }
                }

                if (genEInvMap == null || !genEInvMap.has(Constants.NIC_RESPONSE_STATUS)) {
                    response.setError(true);
                    response.setMessage("IRN Schema Passeed,Response Not Received");
                    JSONArray arrayErrors = new JSONArray();
                    JSONObject errors = new JSONObject();
                    try {
                        errors.put(MESSAGE,
                            "EInvoice NIC Services is not available, please try after sometime");
                        arrayErrors.put(0, errors);
                        errors = new JSONObject();
                        errors.put(ERROR_DETAILS, arrayErrors);
                    } catch (JSONException ex) {
                        logger.error(JSON_EX_MESSAGE, ex);
                    }
                    response.setData(JsonIterator.deserialize(errors.toString(), Object.class));
                    return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
                }

                if (genEInvMap.has(Constants.STATUS) && genEInvMap.getString(Constants.STATUS).equals("000")) {
                    response.setMessage(genEInvMap.getString(MESSAGE));
                    response.setData(genEInvMap.get("response"));
                    return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
                }

                //Awanish changes done
                logger.info("EInvoice-Generate process end for gstin : {}, response : {} ",
                    gstin, genEInvMap);
                if (genEInvMap.get(Constants.NIC_RESPONSE_STATUS).equals(ONE_STRING)) {
                    response.setError(false);
                    response.setStatus(GENERATED_CODE);
                    String ewbNo = genEInvMap.getJSONObject(NIC_RESPONSE_DATA).getString(EWB_NO);
                    String validTill = genEInvMap.getJSONObject(NIC_RESPONSE_DATA).getString(EWB_VALID_TILL);
                    String irn = genEInvMap.getJSONObject(NIC_RESPONSE_DATA).getString(IRN);

                    //        save data in ewb_details table
                    generateEwbDetail(gstin, ewbNo, bu, sbu, location, udId, saveEwbData, docDtls, itemList);
                    if (!NULL_STRING.equals(ewbNo) && !NULL_STRING.equals(validTill)) {
                        response.setMessage(
                            "IRN Schema Validation Passed, Response Successfully Received, IRN & EWB Generated with Part-B");
                    } else if (!NULL_STRING.equals(ewbNo)) {
                        response.setMessage(
                            "IRN Schema Validation Passed, Response Successfully Received, IRN & EWB Generated with Part-A");
                    } else {
                        response.setMessage(
                            "IRN Schema Validation Passed, Response Successfully Received, IRN Generated");
                    }
                    response.setData(JsonIterator.deserialize(genEInvMap.toString(), Object.class));
                } else {
                    if (genEInvMap.getString(ERROR_DETAILS).contains(INVALID_AUTH)) {
                        redisRepo.deleteById(gstin);
                        return generateProcess(customerid, token, username, password, isLive, body);
                    } else if (genEInvMap.getString(ERROR_DETAILS).contains(EWB_ALREADY_GENERATED_FOR_IRN_CODE) &&
                        Objects.isNull(ewbDetailsService.getData(ewbDetails))) {
                        generateEwbDetail(gstin, EWB_FETCH, bu, sbu, location, udId, saveEwbData, docDtls, itemList);
                    }
                    response.setError(true);
                    response.setStatus(Constants.GEN_FAILED);
                    response.setMessage("IRN Schema Validation Passed, Response Successfully Received, IRN Failed");
                    response.setData(JsonIterator.deserialize(genEInvMap.toString(), Object.class));
                    return new ResponseEntity<>(response, HttpStatus.OK);
                }
            } else if (Boolean.parseBoolean(env.getProperty(ENABLE_ONLY_EWB_GENERATION))) {

                JSONObject ewbJsonSchema = new JSONObject(GEN_EWB_PAYLOAD_SCHEMA);
                logger.info("Validating EWB-Gen Schema");
                Schema ewbSchema = SchemaLoader.load(ewbJsonSchema);
                ewbSchema.validate(object);
                logger.info("Validated EWB-Gen Schema");

                boolean isEwbApplicable = false;

                for (int i = 0; i < itemListArray.length(); i++) {
                    JSONObject item = itemListArray.getJSONObject(i);
                    if (item.has(HSNCD) && !item.getString(HSNCD).startsWith("99")) {
                        isEwbApplicable = true;
                        break;
                    }
                }

                if (isEwbApplicable) {
                    JSONObject payload = new JSONObject();
                    payload.put(ACTION, GEN_EWAY_BILL_ACTION);
                    JSONObject data = new JSONObject();
                    payload.put(PAYLOAD_DATA, data);
                    data.put(ITEM_LIST, itemList);
                    data.put(SUPPLY_TYPE, typeAcronym);
                    data.put(SUB_SUPPLY_TYPE, subSupplyType);
                    if (transDtls.has(SUB_TYPE_DESCRIPTION)) {
                        data.put(SUB_SUPPLY_DESC, transDtls.getString(SUB_TYPE_DESCRIPTION));
                    }
                    data.put(GSTIN_ID, gstinMasterService.getGSTINMaster(gstin).getGstinId());
                    String transactionType = transDtls.getString(TYP);
                    for (TransactionType type : TransactionType.values()) {
                        if (transactionType.equalsIgnoreCase(type.toString())) {
                            data.put(TRANSACTION_TYPE, TransactionType.valueOf(transactionType).typeNumber + EMPTY_STRING);
                            break;
                        }
                    }
                    processPayloadService.setDocDetailPayload(data, docDtls);
                    processPayloadService.setSellerDetailPayload(data, sellerDtls);
                    processPayloadService.setBuyerDetailPayload(data, buyerDtls);
                    if (null != valDtls) {
                        processPayloadService.setValueDetailPayload(data, valDtls);
                    }

                    if (jsonBody.has(DISP_DTLS) && !jsonBody.isNull(DISP_DTLS)) {
                        JSONObject dispDtls = jsonBody.getJSONObject(DISP_DTLS);
                        processPayloadService.setDispDetailPayload(data, dispDtls);
                    } else if (!jsonBody.has(DISP_DTLS)){
                        processPayloadService.setDispDetailPayload(data, sellerDtls);
                    }

                    if (jsonBody.has(SHIP_DTLS)  && !jsonBody.isNull(SHIP_DTLS)) {
                        shipDtls = jsonBody.getJSONObject(SHIP_DTLS);
                        processPayloadService.setShippingDetails(data, shipDtls);
                    } else if (!jsonBody.has(SHIP_DTLS)){
                        processPayloadService.setShippingDetails(data, buyerDtls);
                    }

                    processPayloadService.setEwbDetails(data, ewbDtls);
                    JSONObject responseEntity =
                        generateEWBService.generateOnlyEWB(authRes, payload.toString(), ewbDetails);
                    JSONObject responseData = new JSONObject(responseEntity.get(NIC_RESPONSE_DATA).toString());
                    if (!responseData.has(ERROR_CODES)) {
                        response.setError(false);
                        response.setStatus(GENERATED_CODE);
                        response.setMessage(EWB_GEN_MESSAGE);

                        //        save data in ewb_details table
                        String ewbNo = responseData.getString(EWAY_BILL_NO);
                        generateEwbDetail(gstin, ewbNo, bu, sbu, location, udId, saveEwbData, docDtls, itemList);
                        JSONObject nicResponseData = new JSONObject().put(STATUS, ACT).put(EWB_NO, ewbNo).put(
                                EWB_DT, responseData.getString(EWAY_BILL_DATE)).put(EWB_VALID_TILL,
                                responseData.get(VALID_UPTO)).put(REMARKS, responseData.getString(ALERT)).put(
                                IRN, JSONObject.NULL).put(SIGNED_QRCODE, JSONObject.NULL).put(ACK_NO, JSONObject.NULL)
                            .put(ACK_DT, JSONObject.NULL).put(SIGNED_INVOICE, JSONObject.NULL);

                        JSONObject finalData = new JSONObject().put(NIC_RESPONSE_DATA, nicResponseData).put(
                                QRCODE_IMAGE_ENCODED, JSONObject.NULL).put(NIC_GEN_MODE, API)
                            .put(NIC_REQUEST_PAYLOAD,
                                new JSONObject(responseEntity.getString(NIC_REQUEST_PAYLOAD)))
                            .put(NIC_DOCUMENT_STATUS_CREATED_DATE,
                                responseEntity.getString(NIC_DOCUMENT_STATUS_CREATED_DATE))
                            .put(NIC_RESPONSE_CREATED_DATE, responseEntity.getString(NIC_RESPONSE_CREATED_DATE))
                            .put(NIC_STATUS, API).put(NIC_RESPONSE_PLAINTEXT_JSON, NIC_RESPONSE_DATA);

                        response.setData(JsonIterator.deserialize(finalData.toString(), Object.class));
                    } else {
                        response.setError(true);
                        response.setStatus(GEN_FAILED);
                        String errorCodes = String.valueOf(responseData.get(ERROR_CODES));
                        String[] errCodeArr = errorCodes.split(",");
                        JSONArray errDetails = new JSONArray();
                        for (String errCode : errCodeArr) {
                            JSONObject err = new JSONObject();
                            String message = env.getProperty(errCode);
                            err.put(ERR_CODE, errCode);
                            err.put(ERROR_MESSAGE, Objects.nonNull(message) ? message : "");
                            errDetails.put(err);
                        }
                        response.setMessage(
                            "EWB Schema Validation Passed, Response Successfully Received, EWB Generation failed.");

                        JSONObject finalData = new JSONObject().put(NIC_GEN_MODE, API)
                            .put(NIC_REQUEST_PAYLOAD,
                                new JSONObject(responseEntity.getString(NIC_REQUEST_PAYLOAD)))
                            .put(NIC_DOCUMENT_STATUS_CREATED_DATE,
                                responseEntity.getString(NIC_DOCUMENT_STATUS_CREATED_DATE))
                            .put(NIC_RESPONSE_CREATED_DATE, responseEntity.getString(NIC_RESPONSE_CREATED_DATE))
                            .put(NIC_RESPONSE_STATUS, ZERO_STRING).put(INFO_DTLS, JSONObject.NULL)
                            .put(ERROR_DETAILS, errDetails);

                        response.setData(JsonIterator.deserialize(finalData.toString(), Object.class));

                        EwbDetails fetchEwbDetails = new EwbDetails();
                        fetchEwbDetails.setUserGstin(ewbDetails.getUserGstin());
                        fetchEwbDetails.setEwbActive(Y);
                        fetchEwbDetails.setDocNo(ewbDetails.getDocNo());
                        if (errorCodes.contains(EWB_ALREADY_GENERATED_CODE) && Objects.isNull(ewbDetailsService.getData(fetchEwbDetails))){
                            generateEwbDetail(gstin, EWB_FETCH, bu, sbu, location, udId, saveEwbData, docDtls, itemList);
                        }
                    }
                } else {
                    createSchemaSkipResponse(response, gstin, docDtls);
                }
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (ValidationException ve) {
            logger.error("ValidationException for gstin : {}, exception trace : {}",
                gstin, ve.toJSON());
            JSONObject json = ve.toJSON();
            JSONObject errorsDetails;
            try {
                logger.error("json error is:{}", json);
                JSONArray finalJsonArray = new JSONArray();
                if (json.has(CAUSING_EX) && json.getJSONArray(CAUSING_EX).length() > 0) {
                    JSONArray json1 = json.getJSONArray(CAUSING_EX);
                    for (int i = 0; i < json1.length(); i++) {
                        JSONObject errors = new JSONObject();
                        if (json1.getJSONObject(i).has(CAUSING_EX)
                            && json1.getJSONObject(i).getJSONArray(CAUSING_EX).length() > 0) {
                            JSONArray newJsonArray = json1.getJSONObject(i).getJSONArray(CAUSING_EX);
                            for (int j = 0; j < newJsonArray.length(); j++) {
                                JSONObject error = new JSONObject();
                                if (newJsonArray.getJSONObject(j).has(CAUSING_EX)
                                    && newJsonArray.getJSONObject(j).getJSONArray(CAUSING_EX).length() > 0) {
                                    JSONArray newJsonArrayin =
                                        newJsonArray.getJSONObject(j).getJSONArray(CAUSING_EX);
                                    for (int k = 0; k < newJsonArrayin.length(); k++) {
                                        JSONObject errorinfo = new JSONObject();
                                        errorinfo.put(REMARK, newJsonArrayin.getJSONObject(k).getString(MESSAGE));
                                        errorinfo.put(FIELD_NAME,
                                            newJsonArrayin.getJSONObject(k).getString(POINTER_TO_VOILATION)
                                                .replaceAll("#/", EMPTY_STRING).replaceAll("/", "."));
                                        errorinfo.put(VALIDATION_STATUS, ERR_LITERAL);
                                        errorinfo.put(ERROR_CODE, ERR_10000);
                                        finalJsonArray.put(errorinfo);
                                    }
                                } else {
                                    error.put(REMARK, newJsonArray.getJSONObject(j).getString(MESSAGE));
                                    error.put(FIELD_NAME,
                                        newJsonArray.getJSONObject(j).getString(POINTER_TO_VOILATION)
                                            .replaceAll("#/", EMPTY_STRING).replaceAll("/", "."));
                                    error.put(VALIDATION_STATUS, ERR_LITERAL);
                                    error.put(ERROR_CODE, ERR_10000);
                                    finalJsonArray.put(error);
                                }
                            }
                        } else {
                            errors.put(REMARK, json1.getJSONObject(i).getString(MESSAGE));
                            errors.put(FIELD_NAME, json1.getJSONObject(i).getString(POINTER_TO_VOILATION)
                                .replaceAll("#/", EMPTY_STRING).replaceAll("/", "."));
                            errors.put(VALIDATION_STATUS, ERR_LITERAL);
                            errors.put(ERROR_CODE, ERR_10000);
                            finalJsonArray.put(errors);
                        }
                    }
                } else {
                    errorsDetails = new JSONObject();
                    errorsDetails.put(REMARK, json.getString(MESSAGE));
                    errorsDetails.put(FIELD_NAME, json.getString(POINTER_TO_VOILATION)
                        .replaceAll("#/", EMPTY_STRING).replaceAll("/", "."));
                    errorsDetails.put(VALIDATION_STATUS, ERR_LITERAL);
                    errorsDetails.put(ERROR_CODE, ERR_10000);
                    finalJsonArray.put(errorsDetails);
                }
                errorsDetails = new JSONObject();
                errorsDetails.put(ERROR_DETAILS, finalJsonArray);
                logger.info("Final schema validation json is:{}", finalJsonArray);
                response.setError(true);
                response.setStatus(Constants.IRN_SCH_FAILED);
                response.setMessage("Schema Validation Failure");
                response.setData(JsonIterator.deserialize(errorsDetails.toString(), Object.class));
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (HttpClientErrorException e) {
            response.setError(true);
            response.setStatus(Constants.EXCEPTION);
            response.setMessage("IRN Schema Validation Passed, Response Not Received");
            JSONArray arrayErrors = new JSONArray();
            JSONObject errors = new JSONObject();
            try {
                errors.put(MESSAGE, NIC_ERROR + e.getMessage());
                arrayErrors.put(0, errors);
                errors = new JSONObject();
                errors.put(ERROR_DETAILS, arrayErrors);
            } catch (JSONException ex) {
                logger.error(JSON_EX_MESSAGE, ex);
            }
            response.setData(JsonIterator.deserialize(errors.toString(), Object.class));
            logger.error("EInvoice-HttpClientErrorException for gstin : {}, exception trace : {}",
                gstin, e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpServerErrorException e) {
            response.setError(true);
            response.setStatus(Constants.EXCEPTION);
            response.setMessage("IRN Schema Validation Passed, Response Not Received");
            JSONArray arrayErrors = new JSONArray();
            JSONObject errors = new JSONObject();
            try {
                errors.put(MESSAGE, NIC_ERROR + e.getMessage());
                arrayErrors.put(0, errors);
                errors = new JSONObject();
                errors.put(ERROR_DETAILS, arrayErrors);
            } catch (JSONException ex) {
                logger.error(JSON_EX_MESSAGE, ex);
            }
            response.setData(JsonIterator.deserialize(errors.toString(), Object.class));
            logger.error("EInvoice-HttpServerErrorException for gstin : {}, exception trace : {}",
                gstin, e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            response.setError(true);
            response.setStatus(Constants.EXCEPTION);
            response.setMessage(INTERNAL_SERVER_ERROR);
            JSONArray arrayErrors = new JSONArray();
            JSONObject errors = new JSONObject();
            try {
                errors.put(MESSAGE, e.getMessage());
                arrayErrors.put(0, errors);
                errors = new JSONObject();
                errors.put(ERROR_DETAILS, arrayErrors);
            } catch (JSONException ex) {
                logger.error(JSON_EX_MESSAGE, ex);
            }
            response.setData(JsonIterator.deserialize(errors.toString(), Object.class));
            logger.error("EInvoice-Exception for gstin : {}, exception trace : {}",
                gstin, e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private static void createSchemaSkipResponse(ApiResponse response, String gstin, JSONObject docDtls) throws JSONException {
        response.setError(false);
        response.setStatus(GENERATED_CODE);
        response.setMessage(SCHEMA_SKIPPED_MESSAGE);
        JSONObject finalData = new JSONObject().put(INVOICE_NUMBER, docDtls.getString(NO)).put(GSTIN,
            gstin).put(DOCUMENT_DATE, docDtls.getString(DT)).put(DOCUMENT_TYPE, docDtls.getString(
            TYP)).put(VALIDATION_STATUS, SUCCESS).put(VALIDATION_REMARKS, new JSONObject());
        response.setData(JsonIterator.deserialize(finalData.toString(), Object.class));
    }

    private void generateEwbDetail(String gstin, String ewbNo, String bu, String sbu, String location, String udid,
                                   boolean saveEwbData, JSONObject docDtls, JSONArray itemList) throws SQLException,
        JSONException, ParseException {
        if (!NULL_STRING.equals(ewbNo) && !StringUtils.isEmpty(saveEwbData) && saveEwbData) {
            EwbDetails ewbDetails = new EwbDetails();
            ewbDetails.setBu(bu);
            ewbDetails.setSbu(sbu);
            ewbDetails.setLocation(location);
            ewbDetails.setUserGstin(gstin);
            ewbDetails.setUdid(udid);
            ewbDetails.setFu2(ewbNo);
            ewbDetails.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            ewbDetails.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
            ewbDetails = processPayloadService.hardCodeValues(ewbDetails);
            ewbDetails.setItemList(String.valueOf(itemList));

            if (docDtls.has(NO)) {
                ewbDetails.setDocNo(docDtls.getString(NO));
            }

            if (docDtls.has(DT)) {
                java.sql.Date date1 =
                    new java.sql.Date(Constants.nicDateFormat.parse(docDtls.getString(DT)).getTime());
                ewbDetails.setDocDate(date1);
            }

            GSTINMasterEntity gstinMaster = gstinMasterService.getGSTINMaster(gstin);
            ewbDetails.setGstinId(gstinMaster.getGstinId());
            ewbDetails.setCompanyId(gstinMaster.getCompanyId());
            ewbDetails.setCompanyName(gstinMaster.getCompanyName());

            ewbDetails = util.fetchBuId(bu, ewbDetails);
            ewbDetails = util.fetchSbuId(sbu, ewbDetails);
            ewbDetails = util.fetchLocationId(location, ewbDetails);
            ewbDetails = util.generateLoadId(ewbDetails);
            saveDataToUploadTableService.saveData(ewbDetails);
            ewbDetailsService.saveData(ewbDetails);
        }
    }


    @GetMapping(value = "**/ewb-get-byconsigner")
    ResponseEntity<?> getEwbGenByConsignor(
        @RequestHeader(required = true) String gstin,
        @RequestHeader(required = true) Integer customerId,
        @RequestHeader(required = true) String token,
        @RequestParam(required = true) String docType,
        @RequestParam(required = true) String docNo) {
        EWBResponse response = new EWBResponse();
        try {
            logger.info("Received request to get ewb.");
            return getEwbGenByConsignorData(gstin, customerId, token, docType, docNo);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<Object>(JsonIterator.deserialize(e.getResponseBodyAsString(), Object.class),
                e.getStatusCode());
        } catch (Exception e) {
            response.setError(true);
            response.setMessage("Internal Server Error");
            response.setData(null);
            e.printStackTrace();
            return new ResponseEntity<EWBResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    ResponseEntity<?> getEwbGenByConsignorData(String gstin, Integer customerId, String token, String docType, String docNo) throws Exception {
        EWBResponse response = new EWBResponse();

        if (!gstin.matches("^([0-9]{2}[0-9A-Z]{13})$")) {
            response.setError(true);
            response.setMessage("Invalid GSTIN");
            response.setData(null);
            return new ResponseEntity<EWBResponse>(response, HttpStatus.NOT_FOUND);
        } else if (!env.containsProperty("DT_" + docType)) {
            response.setError(true);
            response.setMessage("Invalid docType");
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        GSTINMasterEntity gstinVo = gstinMasterService.getGSTINMaster(gstin);
        if (gstinVo == null) {
            response.setError(true);
//            response.setMessage(Util.ewbErrorCodes.getString("111"));
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        ApiResponse apiResponse = authService.authenticate(gstinVo.getGstin(), gstinVo.getIrnUserName(),
            Encryption.decrypt(gstinVo.getIrnPassword()), customerId, token);

        response.setError(apiResponse.isError());
        response.setData(apiResponse.getData());
        response.setMessage(apiResponse.getMessage());

        if (response.isError()) {
            response.setError(true);
            response.setMessage(NIC_AUTH_FAILED_MESSAGE);
            JSONArray arrayErrors = new JSONArray();
            arrayErrors.put(0, new JSONObject(response.getData().toString()).optJSONObject(Constants.ERROR_DETAILS));
            JSONObject errors = new JSONObject();
            errors.put(ERROR_DETAILS, arrayErrors);
            response.setData(JsonIterator.deserialize(errors.toString(), Object.class));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        ConcurrentHashMap<String, String> genEWBMap = getEwayBillService
            .getEwbGenByConsignor(new JSONObject(JsonStream.serialize(response.getData())), docType, docNo);
        if (genEWBMap.get(RESPONSE_STATUS).equals("1")) {
            response.setError(false);
            response.setMessage("Data Return Successfully");
            response.setData(
                JsonIterator.deserialize(genEWBMap.get( GEN_RESPONSE_PLAINTEXT), Object.class));
        } else {
            response.setError(true);
            response.setMessage(generateNICError(genEWBMap.get(ERR)));
            response.setData(JsonIterator.deserialize(genEWBMap.get(ERR), Object.class));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private String generateNICError(String error) throws Exception {
        JSONObject errorsJson = new JSONObject(error);
        String[] errorCodesArray = errorsJson.getString("errorCodes").split(",");
        String errorMessage = "";
        for (String errCode : errorCodesArray) {
            String message = env.getProperty(errCode);
            errorMessage += Objects.nonNull(message) ? message : "";
        }
        return errorMessage;
    }

    @PostMapping(value = "/v1/pt/irn-generate")
    private ResponseEntity<?> multiRequest(
        @RequestHeader(required = true) Integer customerId,
        @RequestHeader(required = true) String token,
        @RequestHeader(required = false) String username,
        @RequestHeader(required = false) String password,
        @RequestHeader(required = false) String isLive,
        @RequestBody String body) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try {
            List<Callable<ResponseEntity<?>>> tasks = new ArrayList<>();
            JSONArray payloads = new JSONArray(body);
            List<Object> response = new ArrayList<>();
            for (int i = 0; i < payloads.length(); i++) {
                int i1 = i;
                payloads.getJSONObject(i1).put("Version", "1.1");
                Callable<ResponseEntity<?>> callableObj = () -> generateProcess(customerId, token, username, password, isLive,
                    payloads.getJSONObject(i1).toString());
                tasks.add(callableObj);
            }

            List<Future<ResponseEntity<?>>> futures = executorService.invokeAll(tasks);
            for (Future<ResponseEntity<?>> future : futures) {
                response.add(future.get().getBody());
            }
            executorService.shutdown();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            executorService.shutdown();
            ApiResponse response = new ApiResponse();
            response.setError(true);
            response.setStatus(Constants.EXCEPTION);
            response.setMessage(INTERNAL_SERVER_ERROR);
            JSONArray arrayErrors = new JSONArray();
            JSONObject errors = new JSONObject();
            try {
                errors.put(MESSAGE, e.getMessage());
                arrayErrors.put(0, errors);
                errors = new JSONObject();
                errors.put(ERROR_DETAILS, arrayErrors);
            } catch (JSONException ex) {
                logger.error(JSON_EX_MESSAGE, ex);
            }
            response.setData(JsonIterator.deserialize(errors.toString(), Object.class));
            logger.error("Exception for gstin : {}, exception trace: ", EMPTY_STRING, e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private @ResponseBody
    ResponseEntity<?> generateEWBByIrn(Integer customerid, String token, String username, String password,
                                       String isLive,
                                       String body) {
        ApiResponse response = new ApiResponse();
        String gstin = EMPTY_STRING;
        try {
            logger.info("Request Payload is:{}", new JSONObject(body));
            JSONObject object = new JSONObject(body);
            JSONObject jsonSchema = new JSONObject(Constants.GEN_EWB_BY_IRN_PAYLOAD);
            logger.info("Validating IRN-Gen Schema");
            Schema schema = SchemaLoader.load(jsonSchema);
            schema.validate(object);
            logger.info("Validated IRN-Gen Schema");
            gstin = new JSONObject(body).getString(USER_GSTIN);
            String supTyp = EMPTY_STRING;
            if (object.has(TRAN_DTLS)) {
                supTyp = object.optJSONObject(TRAN_DTLS).optString(SUP_TYPE);
            }

            String bu = EMPTY_STRING;
            String sbu = EMPTY_STRING;
            String location = EMPTY_STRING;
            JSONObject jsonBody = new JSONObject(body);
            if (jsonBody.has(MIS_COLUMNS)) {
                bu = jsonBody.getJSONObject(MIS_COLUMNS).getString(BU);
                sbu = jsonBody.getJSONObject(MIS_COLUMNS).getString(SBU);
                location = jsonBody.getJSONObject(MIS_COLUMNS).getString(LOCATION);
            }

            JSONObject docDtls = new JSONObject();
            String docNo = "";
            String udId = gstin;
            if (new JSONObject(body).has(DOC_DTLS)) {
                docDtls = jsonBody.getJSONObject(DOC_DTLS);
                docNo = docDtls.getString(NO);
                udId += COLON + docNo + COLON + (StringUtils.isEmpty(supTyp) ? OUTWARD :
                    supTyp.toUpperCase());
            }
            boolean saveEwbData = Boolean.parseBoolean(env.getProperty(SAVE_ED));
            JSONArray itemListArray = jsonBody.getJSONArray(ITEM_LIST_REQ);
            JSONArray itemList = new JSONArray();
            for (int i = 0; i < itemListArray.length(); i++) {
                JSONObject item = itemListArray.getJSONObject(i);
                itemList.put(i, processPayloadService.setItemDetails(item));
            }

            GSTINMasterEntity gs;
            String uName;
            String pass;
            logger.info("Req_Header UserName : {}", username);
            logger.info("Req_Header password : {}", password);
            if ((username != null) && (password != null)) {
                logger.info("Request Header contains UserName & Password");
                uName = username;
                pass = password;
            } else if ((null == username) && (null == password)) {
                logger.info("..Check database for GSTIN : {}", gstin);
                gs = gstinMasterService.getGSTINMaster(gstin);
                logger.info("gsentity is :{}", new ObjectMapper().writeValueAsString(gs));
                if (null == gs) {
                    response.setError(true);
                    response.setStatus(Constants.PwC_AUTH_FAILED);
                    response.setMessage(PWC_AUTH_FAILED);
                    JSONArray arrayErrors = new JSONArray();
                    JSONObject errors = new JSONObject();
                    errors.put(MESSAGE, "GSTIN Configurations are Missing");
                    arrayErrors.put(0, errors);
                    errors = new JSONObject();
                    errors.put(ERROR_DETAILS, arrayErrors);
                    response.setData(JsonIterator.deserialize(errors.toString(), Object.class));
                    logger.info("Either GSTIN :{} credentials are unavailable", gstin);
                    return new ResponseEntity<>(response, HttpStatus.OK);
                }

                uName = gs.getIrnUserName();
                pass = Encryption.decrypt(gs.getIrnPassword());
            } else {
                logger.info(MISSING_UNAME_OR_PWD);
                response.setError(true);
                response.setStatus(Constants.NIC_AUTH_FAILED);
                response.setMessage(PWC_AUTH_FAILED);
                JSONArray arrayErrors = new JSONArray();
                JSONObject errors = new JSONObject();
                errors.put(MESSAGE, MISSING_UNAME_OR_PWD);
                arrayErrors.put(0, errors);
                errors = new JSONObject();
                errors.put(ERROR_DETAILS, arrayErrors);
                response.setData(JsonIterator.deserialize(errors.toString(), Object.class));
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            logger.info("EInvoice-Authentication process start gstin : {}", gstin);
            final ApiResponse authRes = authService.authenticate(gstin, uName.trim(), pass.trim(), customerid, isLive);
            logger.info(AUTH_END_MESSAGE, gstin, JsonStream.serialize(authRes));
            if (authRes.isError()) {
                authRes.setError(true);
                authRes.setStatus(Constants.NIC_AUTH_FAILED);
                authRes.setMessage(NIC_AUTH_FAILED_MESSAGE);
                JSONArray arrayErrors = new JSONArray();
                arrayErrors.put(0, new JSONObject(authRes.getData().toString()).optJSONObject(Constants.ERROR_DETAILS));
                JSONObject errors = new JSONObject();
                errors.put(ERROR_DETAILS, arrayErrors);
                authRes.setData(JsonIterator.deserialize(errors.toString(), Object.class));
                return new ResponseEntity<>(authRes, HttpStatus.OK);
            }
            logger.info("EInvoice-Generate process start for  gstin : {}", gstin);
            JSONObject genEInvMap = null;
            for (int i = 0; i < 2; i++) {
                try {
                    logger.info("Call EInvoice-Generate process NIC Services at count number is : {} ", i);
                    genEInvMap = genService.generateEwbByIrn(
                        new JSONObject(JsonStream.serialize(authRes.getData())), object, gstin);
                    break;
                } catch (ResourceAccessException e) {
                    Thread.sleep(30000);
                    logger.info("Call EInvoice-Generate process NIC service after 30 second: ", e);

                }
            }
            if (genEInvMap == null || !genEInvMap.has(Constants.NIC_RESPONSE_STATUS)) {
                response.setError(true);
                response.setMessage("IRN Schema Passeed,Response Not Received");
                JSONArray arrayErrors = new JSONArray();
                JSONObject errors = new JSONObject();
                try {
                    errors.put(MESSAGE,
                        "EInvoice-Generate process NIC Services is not available, please try after sometime");
                    arrayErrors.put(0, errors);
                    errors = new JSONObject();
                    errors.put(ERROR_DETAILS, arrayErrors);
                } catch (JSONException ex) {
                    logger.error(JSON_EX_MESSAGE, ex);
                }
                response.setData(JsonIterator.deserialize(errors.toString(), Object.class));
                return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
            }
            logger.info("EInvoice-Generate process end for gstin : {}, response : {} ",
                gstin, genEInvMap);
            if (genEInvMap.get(Constants.NIC_RESPONSE_STATUS).equals(ONE_STRING)) {
                response.setError(false);
                response.setStatus(Constants.EWB_BY_IRN_GENERATED);
                response.setMessage(EWB_GEN_MESSAGE);
                response.setData(JsonIterator.deserialize(genEInvMap.toString(), Object.class));

                String ewbNo =
                    genEInvMap.getJSONObject("nic_response_plaintext_json").getString(EWB_NO);


                //        save data in ewb_details table
                generateEwbDetail(gstin, ewbNo, bu, sbu, location, udId, saveEwbData, docDtls, itemList);
            } else {
                EwbDetails ewbDetails = new EwbDetails();
                ewbDetails.setUserGstin(gstin);
                ewbDetails.setEwbActive(Y);
                ewbDetails.setDocNo(docNo);
                if (genEInvMap.getString(ERROR_DETAILS).contains(INVALID_AUTH)) {
                    redisRepo.deleteById(gstin);
                    return generateEWBByIrn(customerid, token, username, password, isLive, body);
                } else if (genEInvMap.getString(ERROR_DETAILS).contains(EWB_ALREADY_GENERATED_CODE) &&
                    Objects.isNull(ewbDetailsService.getData(ewbDetails))) {
                    generateEwbDetail(gstin, EWB_FETCH, bu, sbu, location, udId, saveEwbData, docDtls, itemList);
                }
                response.setError(true);
                response.setStatus(Constants.EWB_BY_IRN_GEN_FAILED);
                response.setMessage("EWB Schema Validation Passed, Response Successfully Received, EWB Failed");
                response.setData(JsonIterator.deserialize(genEInvMap.toString(), Object.class));
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
        } catch (ValidationException ve) {
            logger.error("ValidationException for gstin : {}, exception trace : {}", gstin, ve.toJSON());
            JSONObject json = ve.toJSON();
            JSONObject errorsDetails;
            try {
                logger.error("json error is:{}", json);
                JSONArray finalJsonArray = new JSONArray();
                if (json.has(CAUSING_EX) && json.getJSONArray(CAUSING_EX).length() > 0) {
                    JSONArray json1 = json.getJSONArray(CAUSING_EX);
                    for (int i = 0; i < json1.length(); i++) {
                        JSONObject errors = new JSONObject();
                        if (json1.getJSONObject(i).has(CAUSING_EX)
                            && json1.getJSONObject(i).getJSONArray(CAUSING_EX).length() > 0) {
                            JSONArray newJsonArray = json1.getJSONObject(i).getJSONArray(CAUSING_EX);
                            for (int j = 0; j < newJsonArray.length(); j++) {
                                JSONObject error = new JSONObject();
                                if (newJsonArray.getJSONObject(j).has(CAUSING_EX)
                                    && newJsonArray.getJSONObject(j).getJSONArray(CAUSING_EX).length() > 0) {
                                    JSONArray newJsonArrayin =
                                        newJsonArray.getJSONObject(j).getJSONArray(CAUSING_EX);
                                    for (int k = 0; k < newJsonArrayin.length(); k++) {
                                        JSONObject errorinfo = new JSONObject();
                                        errorinfo.put(REMARK, newJsonArrayin.getJSONObject(k).getString(MESSAGE));
                                        errorinfo.put(FIELD_NAME,
                                            newJsonArrayin.getJSONObject(k).getString(POINTER_TO_VOILATION)
                                                .replaceAll("#/", EMPTY_STRING).replaceAll("/", "."));
                                        errorinfo.put(VALIDATION_STATUS, ERR_LITERAL);
                                        errorinfo.put(ERROR_CODE, ERR_10000);
                                        finalJsonArray.put(errorinfo);
                                    }
                                } else {
                                    error.put(REMARK, newJsonArray.getJSONObject(j).getString(MESSAGE));
                                    error.put(FIELD_NAME,
                                        newJsonArray.getJSONObject(j).getString(POINTER_TO_VOILATION)
                                            .replaceAll("#/", EMPTY_STRING).replaceAll("/", "."));
                                    error.put(VALIDATION_STATUS, ERR_LITERAL);
                                    error.put(ERROR_CODE, ERR_10000);
                                    finalJsonArray.put(error);
                                }
                            }
                        } else {
                            errors.put(REMARK, json1.getJSONObject(i).getString(MESSAGE));
                            errors.put(FIELD_NAME, json1.getJSONObject(i).getString(POINTER_TO_VOILATION)
                                .replaceAll("#/", EMPTY_STRING).replaceAll("/", "."));
                            errors.put(VALIDATION_STATUS, ERR_LITERAL);
                            errors.put(ERROR_CODE, ERR_10000);
                            finalJsonArray.put(errors);
                        }
                    }
                } else {
                    errorsDetails = new JSONObject();
                    errorsDetails.put(REMARK, json.getString(MESSAGE));
                    errorsDetails.put(FIELD_NAME, json.getString(POINTER_TO_VOILATION)
                        .replaceAll("#/", EMPTY_STRING).replaceAll("/", "."));
                    errorsDetails.put(VALIDATION_STATUS, ERR_LITERAL);
                    errorsDetails.put(ERROR_CODE, ERR_10000);
                    finalJsonArray.put(errorsDetails);
                }
                errorsDetails = new JSONObject();
                errorsDetails.put(ERROR_DETAILS, finalJsonArray);
                logger.info("Final schema validation json is:{}", finalJsonArray);
                response.setError(true);
                response.setStatus(Constants.EWB_BY_IRN_SCH_FAILED);
                response.setMessage("Schema Validation Failure");
                response.setData(JsonIterator.deserialize(errorsDetails.toString(), Object.class));
                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (HttpClientErrorException e) {
            response.setError(true);
            response.setStatus(Constants.EXCEPTION);
            response.setMessage("EWB Schema Validation Passed, Response Not Received");
            JSONArray arrayErrors = new JSONArray();
            JSONObject errors = new JSONObject();
            try {
                errors.put(MESSAGE, NIC_ERROR + e.getMessage());
                arrayErrors.put(0, errors);
                errors = new JSONObject();
                errors.put(ERROR_DETAILS, arrayErrors);
            } catch (JSONException ex) {
                logger.error(JSON_EX_MESSAGE, ex);
            }
            response.setData(JsonIterator.deserialize(errors.toString(), Object.class));
            logger.error("EInvoice-HttpClientErrorException for gstin : {}, exception trace : {}",
                gstin, e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (HttpServerErrorException e) {
            response.setError(true);
            response.setStatus(Constants.EXCEPTION);
            response.setMessage("EWB Schema Validation Passed, Response Not Received");
            JSONArray arrayErrors = new JSONArray();
            JSONObject errors = new JSONObject();
            try {
                errors.put(MESSAGE, NIC_ERROR + e.getMessage());
                arrayErrors.put(0, errors);
                errors = new JSONObject();
                errors.put(ERROR_DETAILS, arrayErrors);
            } catch (JSONException ex) {
                logger.error(JSON_EX_MESSAGE, ex);
            }
            response.setData(JsonIterator.deserialize(errors.toString(), Object.class));
            logger.error("EInvoice-HttpServerErrorException for gstin : {}, exception trace : {}",
                gstin, e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            response.setError(true);
            response.setStatus(Constants.EXCEPTION);
            response.setMessage(INTERNAL_SERVER_ERROR);
            JSONArray arrayErrors = new JSONArray();
            JSONObject errors = new JSONObject();
            try {
                errors.put(MESSAGE, e.getMessage());
                arrayErrors.put(0, errors);
                errors = new JSONObject();
                errors.put(ERROR_DETAILS, arrayErrors);
            } catch (JSONException ex) {
                logger.error(JSON_EX_MESSAGE, ex);
            }
            response.setData(JsonIterator.deserialize(errors.toString(), Object.class));
            logger.error("EInvoice-Exception for gstin : {}, exception trace : {}",
                gstin, e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/v1/pt/ewbbyirn")
    private ResponseEntity<?> multiRequestForEWB(
        @RequestHeader(required = true) Integer customerId,
        @RequestHeader(required = true) String token,
        @RequestHeader(required = false) String username,
        @RequestHeader(required = false) String password,
        @RequestHeader(required = false) String isLive,
        @RequestBody String body) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        try {
            List<Callable<ResponseEntity<?>>> tasks = new ArrayList<>();
            JSONArray payloads = new JSONArray(body);
            List<Object> response = new ArrayList<>();
            for (int i = 0; i < payloads.length(); i++) {
                int i1 = i;
                Callable<ResponseEntity<?>> callableObj = () -> generateEWBByIrn(customerId, token, username, password, isLive,
                    payloads.getJSONObject(i1).toString());
                tasks.add(callableObj);
            }

            List<Future<ResponseEntity<?>>> futures = executorService.invokeAll(tasks);
            for (Future<ResponseEntity<?>> future : futures) {
                response.add(future.get().getBody());
            }
            executorService.shutdown();
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            executorService.shutdown();
            ApiResponse response = new ApiResponse();
            response.setError(true);
            response.setStatus(Constants.EXCEPTION);
            response.setMessage(INTERNAL_SERVER_ERROR);
            JSONArray arrayErrors = new JSONArray();
            JSONObject errors = new JSONObject();
            try {
                errors.put(MESSAGE, e.getMessage());
                arrayErrors.put(0, errors);
                errors = new JSONObject();
                errors.put(ERROR_DETAILS, arrayErrors);
            } catch (JSONException ex) {
                logger.error(JSON_EX_MESSAGE, ex);
            }
            response.setData(JsonIterator.deserialize(errors.toString(), Object.class));
            logger.error("Exception for gstin : {}, exception trace: ", EMPTY_STRING, e);
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static JSONObject transferJsonKey(JSONObject jsonObject) throws JSONException, IOException {
        JSONObject object = new JSONObject();
        Iterator iterator = jsonObject.keys();
        while (iterator.hasNext()) {
            String jsonKey = (String) iterator.next();
            Object valueObject = jsonObject.get(jsonKey);
            if (valueObject.getClass().toString().endsWith("Double") ||
                valueObject.getClass().toString().endsWith("Integer")) {
                object.accumulate(jsonKey, valueObject);
            }
            if (valueObject.getClass().toString().endsWith("String")) {
                String uppercase = valueObject.toString();
                object.accumulate(jsonKey, uppercase.toUpperCase());
            } else if (valueObject.getClass().toString().endsWith("JSONObject")) {
                JSONObject checkObject = JsonIterator.deserialize(valueObject.toString(), JSONObject.class);
                if (checkObject.length() <= 0) {
                    object.accumulate(jsonKey, transferJsonKey((JSONObject) valueObject));
                } else {
                    object.accumulate(jsonKey, null);
                }
            } else if (valueObject.getClass().toString().endsWith("JSONArray")) {
                object.accumulate(jsonKey, transferJsonArray(jsonObject.getJSONArray(jsonKey)));
            }
        }
        return new JSONObject(object.toString().replace("[[", "[").replace("]]", "]"));
    }


    public static JSONArray transferJsonArray(JSONArray jsonArray) throws JSONException, IOException {
        JSONArray array = new JSONArray();
        if (null != jsonArray && jsonArray.length() > 0) {
            for (int i = 0; i < jsonArray.length(); i++) {
                if (jsonArray.get(i).getClass().toString().endsWith("JSONObject")) {
                    array.put(transferJsonKey((JSONObject) jsonArray.get(i)));
                } else if (jsonArray.get(i).getClass().toString().endsWith("JSONArray")) {
                    array.put(transferJsonArray((JSONArray) jsonArray.get(i)));
                }
            }
        }
        return array;
    }

}
