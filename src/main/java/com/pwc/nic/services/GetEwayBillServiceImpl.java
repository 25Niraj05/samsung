package com.pwc.nic.services;

import com.pwc.nic.util.Constants;
import com.pwc.nic.util.EncryptUtil;
import com.pwc.nic.util.RestUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Base64;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

import static com.pwc.nic.util.Constants.*;

@Service
public class GetEwayBillServiceImpl implements GetEwayBillService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GetEwayBillServiceImpl.class);

    @Autowired
    private Environment env;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public ConcurrentHashMap<String, String> getEwbGenByConsignor(JSONObject authResponse, String docType, String docNo)
            throws Exception {
        ConcurrentHashMap<String, String> ewbDetailMap = new ConcurrentHashMap<>();
        HttpHeaders headers = createHeader(authResponse);
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(/*Util.userConfig.getString("nic_base_url")*/env.getRequiredProperty(
                    "NIC_BASE_URL") + "/ewayapi/GetEwayBillGeneratedByConsigner").queryParam("docType", docType)
                .queryParam("docNo", docNo);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(builder.build().toUriString(), HttpMethod.GET,
                entity, String.class);

        ewbDetailMap.put("gen_request_header", entity.getHeaders().toString());

        if (RestUtils.isError(responseEntity.getStatusCode())) {
            JSONObject resJson = new JSONObject(responseEntity.getBody());
            ewbDetailMap.put(RESPONSE_STATUS, responseEntity.getStatusCode().toString());
            ewbDetailMap.put("http_response_code", responseEntity.getStatusCode().toString());
            ewbDetailMap.put("gen_response_encoded", responseEntity.getBody());
            ewbDetailMap.put("gen_response_plaintext",
                    Base64.getDecoder().decode(resJson.getString(ERR)).toString());
            ewbDetailMap.put("response_status", resJson.getString(RESPONSE_STATUS));
        } else {
            ewbDetailMap.put("http_response_code", responseEntity.getStatusCode().toString());
            String response = responseEntity.getBody();
            Base64.Decoder b64Decoder = Base64.getDecoder();
            JSONObject responseJson = new JSONObject(response);
            String genStatus = responseJson.getString(RESPONSE_STATUS);
            ewbDetailMap.put(RESPONSE_STATUS, genStatus);
            ewbDetailMap.put("gen_response_encoded", response);
            if (null != genStatus && genStatus.equals("1")) {
                String responseRek = EncryptUtil.decryptByRek(responseJson.getString("rek"),
                        authResponse.getString("Sek"));
                String responseData = EncryptUtil.decrypt(responseJson.getString("data"), responseRek);
                JSONObject jsonResponse = new JSONObject(responseData);
                ewbDetailMap.put("gen_response_plaintext", responseData);
                ewbDetailMap.put("response_status", "1");
                ewbDetailMap.put("ewayBillNo", jsonResponse.optString("ewayBillNo"));
                ewbDetailMap.put("ewayBillDate", jsonResponse.optString("ewayBillDate"));
            } else {
                String decodedError = new String(b64Decoder.decode(responseJson.getString(ERR)));
                ewbDetailMap.put(GEN_RESPONSE_PLAINTEXT, decodedError);
                ewbDetailMap.put("response_status", "0");
                ewbDetailMap.put(ERR, decodedError);
            }
        }
        return ewbDetailMap;
    }

    private static HttpHeaders createHeader(JSONObject authResponse) throws JSONException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("gstin", authResponse.getString("gstin"));
        headers.add("authtoken", authResponse.getString(AUTHTOKEN));
        headers.add("X-Asp-Auth-Token", authResponse.getString("tkey"));
        headers.add("X-Asp-Auth-Signature", authResponse.getString("authkey"));
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return headers;
    }
}
