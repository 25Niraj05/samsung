package com.pwc.nic.services;

import com.pwc.nic.model.EWBVehicleDetailsEntity;
import com.pwc.nic.model.EwbDetails;
import com.pwc.nic.util.*;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static com.pwc.nic.util.Constants.*;

@Service
public class GenerateEWBServiceImpl implements GenerateEWBService{

    private static final Logger LOGGER = LoggerFactory.getLogger(GenerateEWBServiceImpl.class);

    private EwbDetails ewbDetails;
    private String gstin;
    private String supperUser;
    private JSONObject infoJson;
    private List<EWBVehicleDetailsEntity> vehList = null;
    private boolean isTokenValid = true;

    @Autowired
    private Environment env;

    @Autowired
    private Utils util;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public JSONObject generateOnlyEWB(ApiResponse authResponse, String payload, EwbDetails ewbDetails) {
        JSONObject genEWBMap = new JSONObject();
        try {
            this.ewbDetails = util.generateLoadId(ewbDetails);
        } catch (SQLException e) {
            LOGGER.info("A SQLException occurred: ", e);
        }
        gstin = this.ewbDetails.getUserGstin();
        supperUser = env.getProperty("demo.dns.name");
        if (null!=authResponse.getData() && ((String)((Map)authResponse.getData()).get("Status")).equalsIgnoreCase("1")) {
            for (int i = 1; i < 3; i++) {
                try {
                    try {
                        genEWBMap = genrateEWAYBill((Map) authResponse.getData(), payload);
                        LOGGER.info("The EWB is successfully generated with the following response: {}", genEWBMap);
                        JSONObject nicResponseData = new JSONObject(genEWBMap.getString(NIC_RESPONSE_DATA));

                        if (nicResponseData.has(ERROR_CODES) &&
                            Arrays.asList(nicResponseData.getString(ERROR_CODES).split(",")).contains("702")) {

                            genEWBMap = genrateEWAYBill((Map) authResponse.getData(),
                                new JSONObject().put(PAYLOAD_DATA,
                                    new JSONObject(payload).getJSONObject("data").put("transDistance", 0)).toString());
                        }
                        genEWBMap.put(Constants.NIC_RESPONSE_CREATED_DATE,new Timestamp(System.currentTimeMillis()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                } catch (ResourceAccessException e) {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }
        return genEWBMap;
    }

    private JSONObject genrateEWAYBill(Map<String, String> authResponseDataMap,
                                                              String payload)
        throws Exception {
        JSONObject genEWBMap = new JSONObject();
        genEWBMap.put(Constants.NIC_REQUEST_PAYLOAD, payload);
        genEWBMap.put(Constants.NIC_DOCUMENT_STATUS_CREATED_DATE, new Timestamp(System.currentTimeMillis()).toString());
        genEWBMap.put(Constants.NIC_GEN_MODE, API);
        String sekKey = authResponseDataMap.get(SEK);
        String data = Encryption.encrypt(sekKey, new JSONObject(payload).getString(PAYLOAD_DATA));
        HttpHeaders headers = createHeader(authResponseDataMap);
        String requestJson = new JSONObject().put(ACTION, GEN_EWAY_BILL_ACTION).put(PAYLOAD_DATA, data).toString();
        HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);

        // possible cause delay
        LOGGER.info("{}-GENEWAYBILL process started with payload: {} and headers:{}", supperUser, payload, headers);
        ResponseEntity<String> responseEntity = restTemplate
            .postForEntity(env.getRequiredProperty("GENRATE_EWAY_BILL_URL"), entity, String.class);
        LOGGER.info("Received respose for EWB generation call to NIC:{}", responseEntity);
        genEWBMap.put("gen_request_header", entity.getHeaders().toString());
        JSONObject responseBody = new JSONObject(responseEntity.getBody());
        String decryptedData;
        if ("1".equals(responseBody.get(RESPONSE_STATUS))){

            decryptedData = Encryption.decrypt(responseBody.getString(PAYLOAD_DATA), sekKey);
        } else {
            decryptedData = new String(Base64.getDecoder().decode(responseBody.getString(ERR)));
        }
        genEWBMap.put(NIC_RESPONSE_DATA, decryptedData);
        return genEWBMap;
    }

    private HttpHeaders createHeader(Map<String, String> authResponse) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add(GSTIN_REQ, gstin);
        headers.add("AuthToken", authResponse.get(Constants.AUTHTOKEN));
        headers.add("X-Asp-Auth-Token", authResponse.get(Constants.TKEY));
        headers.add("X-Asp-Auth-Signature", authResponse.get(Constants.AUTHKEY));
        headers.add("user_name", authResponse.get("userName"));
        return headers;
    }

    private void setInfo(String info, ConcurrentHashMap<String, String> genEWBMap) {
        if (!"".equals(info)) {
            try {
                genEWBMap.put(Constants.INFO, new String(Base64.getDecoder().decode(info)));
                infoJson = new JSONObject(genEWBMap.get(Constants.INFO));
            } catch (Exception e) {
                genEWBMap.put(Constants.INFO, info);
            }
        }
    }

    public ConcurrentHashMap<String, String> getEwayBillDetails(Map<String, String> authResponse, String ewayBillNo) {

        ConcurrentHashMap<String, String> ewbDetailMap = new ConcurrentHashMap<>();
        try {
            HttpHeaders headers = createHeader(authResponse);
            UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(env.getRequiredProperty("GET_EWAY_BILL_URL")).queryParam("ewbNo", ewayBillNo);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            LOGGER.info("{}- getEwayBillDetails process Starts for UDID : {} ewayBillNo : {} and headers: {}", supperUser,
                ewbDetails.getUdid(), ewayBillNo, headers);
            ResponseEntity<String> responseEntity = restTemplate.exchange(builder.build().toUriString(), HttpMethod.GET,
                entity, String.class);
            if (HttpStatus.Series.CLIENT_ERROR.equals(responseEntity.getStatusCode().series())
                || HttpStatus.Series.SERVER_ERROR.equals(responseEntity.getStatusCode().series())) {
                LOGGER.info(
                    "{}-getEwayBillDetails Api for ewayBillNo : {} and UDID : {} returned response code server or client errors response code, {}",
                    supperUser, ewayBillNo, ewbDetails.getUdid(), responseEntity.getStatusCode());
                ewbDetailMap.put("http_response_code", responseEntity.getStatusCode().toString());

            } else {
                String response = responseEntity.getBody();
                JSONObject json = new JSONObject(response);
                if (json.has(Constants.ERROR)) {
                    Base64.Decoder b64 = Base64.getDecoder();
                    String errorMessage = new String(b64.decode(json.getString(Constants.ERROR)));
                    ewbDetailMap.put("respnose_errors", response);
                    LOGGER.info("{}-getEwayBillDetails Api for ewayBillNo : {} and UDID : {} returned Error response : {}",
                        supperUser, ewayBillNo, ewbDetails.getUdid(), errorMessage);

                } else {
                    String responseRek = Encryption.decryptByRek(json.getString("rek"), authResponse.get("sek"));
                    String responseData = Encryption.decrypt(json.getString(PAYLOAD_DATA), responseRek);
                    ewbDetailMap.put(Constants.RESPNOSE_ENCRYPT, responseEntity.getBody());
                    ewbDetailMap.put(Constants.RESPONSE_DECRYPT, responseData);
                    LOGGER.info(
                        "{}-getEwayBillDetails Api for ewayBillNo : {} and UDID : {} returned success response data : {}",
                        supperUser, ewayBillNo, ewbDetails.getUdid(), responseData);

                }
            }
        } catch (Exception e) {
            LOGGER.error(
                "Exception getEwayBillDetails for ewayBillNo : {} and UDID : {} in GetEWBDetailsApi process Failed exception trace : {}",
                ewayBillNo, ewbDetails.getUdid(), e);
        }

        return ewbDetailMap;
    }

}
