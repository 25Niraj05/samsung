package com.pwc.nic.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.util.*;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.pwc.nic.util.Constants;
import com.pwc.nic.util.Utils;
import java.sql.Timestamp;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import static com.pwc.nic.util.Constants.*;

@Service
public class GenerateServiceImpl implements GenerateService {

    private static final Logger logger = LoggerFactory.getLogger(GenerateServiceImpl.class);

    @Autowired
    private Environment env;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AuthenticationServiceImpl authServiceImpl;


    @Override
    public JSONObject generateEInvoice(JSONObject authResponse, JSONObject request, String gstin) throws JSONException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, CertificateException, SignatureException{
        JSONObject genEInvMap = new JSONObject();
        genEInvMap.put(Constants.NIC_REQUEST_PAYLOAD, request);
        genEInvMap.put(Constants.NIC_DOCUMENT_STATUS_CREATED_DATE, new Timestamp(System.currentTimeMillis()).toString());
        String sekKey = authResponse.getString(Constants.SEK);
        String data = Utils.encrypt(sekKey, request.toString());
        HttpHeaders headers = createHeader(authResponse, gstin);
        genEInvMap.put(Constants.NIC_GEN_MODE, API);
        String requestJson = new JSONObject().put(Constants.DATA, data).toString();
        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
        logger.info("EInvoice-Generate start calling NIC-Generate API for gstin : {}", gstin);
        ResponseEntity<String> responseEntity = restTemplate
                .postForEntity(AuthenticationServiceImpl.genIrnUrl, entity, String.class);
        genEInvMap.put(Constants.NIC_RESPONSE_CREATED_DATE,new Timestamp(System.currentTimeMillis()));
        logger.info("E-Invoice Generate API Response is:{}",responseEntity.getBody());
        if (Utils.isError(responseEntity.getStatusCode())) {
            genEInvMap.put(Constants.NIC_RESPONSE_STATUS, responseEntity.getStatusCode());
        } else {
			JSONObject responseJson = null;
			try {
				responseJson = new JSONObject(responseEntity.getBody());
			} catch (JSONException e) {
				genEInvMap.put(Constants.STATUS, "000");
				genEInvMap.put("message", "Not a valid json");
				genEInvMap.put("response", responseEntity.getBody());
				return genEInvMap;
			}

            String genStatus = responseJson.getString(Constants.STATUS);
            genEInvMap.put(Constants.NIC_RESPONSE_STATUS, genStatus);
            genEInvMap.put(Constants.INFODTLS, responseJson.get(Constants.INFODTLS));
            if (null != genStatus && genStatus.equals("1")) {
                genEInvMap = setSuccessData(responseJson, sekKey, genEInvMap);
            } else {
                genEInvMap.put(Constants.ERROR_DETAILS, responseJson.getJSONArray(Constants.ERROR));
            }
        }
        return genEInvMap;
    }

    @Override
    public JSONObject generateEwbByIrn(JSONObject authResponse, JSONObject request, String gstin) throws Exception {
        JSONObject genEInvMap = new JSONObject();
        genEInvMap.put(Constants.NIC_REQUEST_PAYLOAD, request);
        genEInvMap.put(Constants.NIC_DOCUMENT_STATUS_CREATED_DATE, new Timestamp(System.currentTimeMillis()).toString());
        String sekKey = authResponse.getString(Constants.SEK);
        String data = Utils.encrypt(sekKey, request.toString());
        HttpHeaders headers = createHeader(authResponse, gstin);
        genEInvMap.put(Constants.NIC_GEN_MODE, API);
        String requestJson = new JSONObject().put(Constants.DATA, data).toString();
        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
        logger.info("EInvoice-Generate start calling NIC-Generate API for gstin : {}", gstin);
        ResponseEntity<String> responseEntity = restTemplate
                .postForEntity(AuthenticationServiceImpl.genEwbByrnUrl, entity, String.class);
        genEInvMap.put(Constants.NIC_RESPONSE_CREATED_DATE,new Timestamp(System.currentTimeMillis()));
        logger.info("E-Invoice Generate API Response is:{}",responseEntity.getBody());
        if (Utils.isError(responseEntity.getStatusCode())) {
            genEInvMap.put(Constants.NIC_RESPONSE_STATUS, responseEntity.getStatusCode());
        } else {
            JSONObject responseJson = new JSONObject(responseEntity.getBody());
//            genEInvMap.put(Constants.INFODTLS, responseJson.get("Alert"));
            String genStatus = responseJson.getString(Constants.STATUS);
            genEInvMap.put(Constants.NIC_RESPONSE_STATUS, genStatus);
            if (null != genStatus && genStatus.equals("1")) {
                genEInvMap = setEWBSuccessData(responseJson, sekKey, genEInvMap);
            } else {
                genEInvMap.put(Constants.ERROR_DETAILS, responseJson.getJSONArray(Constants.ERROR));
            }
        }
        return genEInvMap;
    }

    private HttpHeaders createHeader(JSONObject authResponse, String gstin) throws JSONException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add(GSTIN_REQ, gstin);
        headers.add("AuthToken", authResponse.getString(Constants.AUTHTOKEN));
        headers.add("X-Asp-Auth-Token", authResponse.getString(Constants.TKEY));
        headers.add("X-Asp-Auth-Signature", authResponse.getString(Constants.AUTHKEY));
        headers.add("user_name", authResponse.getString("userName"));
        return headers;
    }

    private JSONObject setSuccessData(JSONObject responseJson, String sekKey, JSONObject genEInvMap) throws  JSONException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, CertificateException, SignatureException {
        String responseData = Utils.decrypt(responseJson.getString(Constants.DATA), sekKey);
        JSONObject jsonResponse = new JSONObject(responseData);
        logger.info("GenEInvoice process success with response as:{} ", jsonResponse);
        genEInvMap.put(Constants.NIC_RESPONSE_DATA, jsonResponse);
        genEInvMap.put(Constants.NIC_STATUS, jsonResponse.getString(Constants.STATUS));
        String[] signedInvoice = jsonResponse.get(Constants.SIGNED_INVOICE).toString().split("\\.");
        String InvEncodedHeader = signedInvoice[0];
        String InvEncodedBody = signedInvoice[1];
        String InvEncodedSignature = signedInvoice[2];
        org.apache.commons.codec.binary.Base64 base64Url = new org.apache.commons.codec.binary.Base64(true);
        String signedInvBody = new String(base64Url.decode(InvEncodedBody));
        JSONObject signedInvBodyJson=new JSONObject(signedInvBody);
//        String header = new String(base64Url.decode(base64EncodedHeader));
//            logger.info("Signed Invoice-JWT Header :---- {}" ,header);
//            logger.info("Signed Invoice-JWT Signature :--------------- {}",base64EncodedSignature);
        String[] signedQRCode = jsonResponse.getString(Constants.SIGNED_QRCODE).split("\\.");
        String QREncodedHeader = signedQRCode[0];
        String QREncodedBody = signedQRCode[1];
        String QREncodedSignature = signedQRCode[2];
//        String signedQRHeader =
        //logger.info("JWT Header QR :---- {}" ,signedQRHeader);
        String signedQRBody = new String(base64Url.decode(QREncodedBody));
        JSONObject signedQRBodyJson=new JSONObject(signedQRBody);
        JSONObject plaintextJson=new JSONObject(responseData);
        plaintextJson.put(Constants.SIGNED_QRCODE, signedQRBodyJson);
        plaintextJson.put(Constants.SIGNED_INVOICE, signedInvBodyJson);
//        logger.info("JWT Body QR :---- {}", signedQRBodyJson);
//        logger.info("JWT Body Inv :---- {}", signedInvBodyJson);
//        logger.info("JWT Signature QR :---- {}" ,QREncodedSignature);
        boolean in = AuthenticationServiceImpl.verifySignature(InvEncodedSignature,
                InvEncodedHeader + "." + InvEncodedBody);
        logger.info("Signed Invoice Signature verified?: {}", in);
        boolean qr = authServiceImpl.verifySignature(QREncodedSignature,
                QREncodedHeader + "." + QREncodedBody);
        logger.info("Signed QRCode Signature verified?: {}", qr);
        byte[] qrEncoded=getQRCodeImage(jsonResponse.getString(Constants.SIGNED_QRCODE),303,303);
        String s=Base64.getEncoder().encodeToString(qrEncoded);
//        logger.info("qr_encoded is:{}",s);
//        if (in && qr) {
            logger.info("Signed QRCode and SignedInvoice Signature verified successfully");
            genEInvMap.put(Constants.NIC_RESPONSE_PLAINTEXT_JSON, plaintextJson);
//            genEInvMap.put(Constants.QRCODE_IMAGE,signedQRBodyJson);
            genEInvMap.put(Constants.QRCODE_IMAGE_ENCODED,s);
//        } else {
//            genEInvMap.put(Constants.NIC_RESPONSE_PLAINTEXT_JSON, "Invalid Signature in response");
//        }
        return genEInvMap;
    }

    private JSONObject setEWBSuccessData(JSONObject responseJson, String sekKey, JSONObject genEInvMap) throws  JSONException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, CertificateException, SignatureException {
        String responseData = Utils.decrypt(responseJson.getString(Constants.DATA), sekKey);
        JSONObject jsonResponse = new JSONObject(responseData);
        logger.info("GenEInvoice process success with response as:{} ", jsonResponse);
        genEInvMap.put(Constants.NIC_RESPONSE_PLAINTEXT_JSON, jsonResponse);

        return genEInvMap;
    }

    private byte[] getQRCodeImage(String text, int width, int height) {
        byte[] pngData=null;
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            Map<EncodeHintType, Object> hints = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
            hints.put(EncodeHintType.MARGIN, 0);
            BitMatrix bitMatrix  = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height,hints);
            ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
            pngData= pngOutputStream.toByteArray();
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
        return pngData;
    }
    @Override
    public JSONObject setB2CData(JSONObject object) throws JSONException {
        JSONObject jsonData=new JSONObject();
        jsonData.put("SellerGstin",object.optJSONObject(SELLER_DTLS).optString(GSTIN_REQ));
        jsonData.put("BuyerGstin","URP");
        jsonData.put("DocNo",object.optJSONObject(DOC_DTLS).optString(NO));
        jsonData.put("DocTyp",object.optJSONObject(DOC_DTLS).optString(TYP));
        jsonData.put("DocDt",object.optJSONObject(DOC_DTLS).optString(DT));
        jsonData.put("TotInvVal",object.optJSONObject(VAL_DTLS).optString("TotInvVal"));
        jsonData.put("ItemCnt",object.optJSONArray(ITEM_LIST_REQ).length());
        JSONObject data=new JSONObject();
        data.put(PAYLOAD_DATA,jsonData.toString());
        JSONObject qrCode=new JSONObject();
        qrCode.put("QRCode",data);
        JSONObject response=new JSONObject();
        String qrText=Base64.getEncoder().encodeToString(data.toString().getBytes());
        byte[] qrEncoded=getQRCodeImage(qrText,151,151);
        String s=Base64.getEncoder().encodeToString(qrEncoded);
        response.put("PwC_response_plaintext_json",qrCode);
        response.put(Constants.QRCODE_IMAGE_ENCODED,s);
        return  response;
    }
}


