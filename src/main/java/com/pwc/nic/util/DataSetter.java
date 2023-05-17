package com.pwc.nic.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pwc.nic.model.EWBVehicleDetailsEntity;
import com.pwc.nic.model.EwbDetails;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DataSetter {

    @Autowired
    private static Environment env;

    private static ObjectMapper objectMapper = new ObjectMapper();

//    public static Map<String, Object> setDataFromGetApi(ConcurrentHashMap<String, String> ewbDetailMap,
//    EwbDetails ewbDetails) throws Exception {
//        JSONObject ewbDetailsObj = new JSONObject(ewbDetailMap);
//        Map<String, Object> map = new HashMap();
//        String genStatus = null;
//        List<EWBVehicleDetailsEntity> vehicleList;
//        if (ewbDetailsObj.has(Constants.RESPONSE_DECRYPT)) {
//            DecryptResponseMapper decryptedResponse =
//                objectMapper.readValue(ewbDetailsObj.getString(Constants.RESPONSE_DECRYPT),
//                DecryptResponseMapper.class);
//            ewbDetails.setNicGetResponseJson(objectMapper.writeValueAsString(decryptedResponse));
//            ewbDetails.setEwayBillNo(decryptedResponse.getEwbNo());
//            ewbDetails.setNicGenMode(decryptedResponse.getGenMode());
//            ewbDetails.setNicStatus(decryptedResponse.getStatus());
//            genStatus = Constants.GENERATED;
//            ewbDetails.setEwbGenerationStatus(genStatus);
//            ewbDetails.setNicDocumentStatus(genStatus);
//            ewbDetails.setVehicleListDetails(objectMapper.writeValueAsString(decryptedResponse.getVehiclListDetails()));
//            vehicleList = new ObjectMapper().readValue(ewbDetails.getVehicleListDetails(),
//                new TypeReference<List<EWBVehicleDetailsEntity>>() {
//                });
//            for (EWBVehicleDetailsEntity vehicle : vehicleList)
//                vehicle.setEwbNo(String.valueOf(ewbDetails.getEwayBillNo()));
//            ewbDetails.setNicNoValidDays(decryptedResponse.getNoValidDays());
//            ewbDetails.setNicActualDistance(decryptedResponse.getActualDist());
//            ewbDetails.setNicEwayBillDate(Utils.getTimestamp(decryptedResponse.getEwayBillDate()));
//            ewbDetails.setEWBDateAmpm(decryptedResponse.getEwayBillDate());
//            ewbDetails.setEwayBillValidUpto(Utils.getTimestamp(decryptedResponse.getValidUpto()));
//            ewbDetails.setEwbValidUptoAmpm(decryptedResponse.getValidUpto());
//            ewbDetails.setNicExtendedTimes(decryptedResponse.getExtendedTimes());
//            ewbDetails.setNicRejectStatus(decryptedResponse.getRejectStatus());
//            String urlFromProperty = env.getProperty("demo.detail.report.url");
//            String dnsName = env.getProperty("demo.dns.name");
//            String reportUrl = (StringUtils.isEmpty(urlFromProperty)?"url":urlFromProperty).concat("id=")
//                .concat(Integer.toString(ewbDetails.getId())).concat("&name=")
//                .concat(StringUtils.isEmpty(dnsName)?:).concat("&type=").concat(ewbDetails.getIsPartbUpdated())
//                .concat("&docno=").concat(ewbDetails.getDocumentNo());
//            ewbDetails.setReportUrl(reportUrl);
//            ewbDetails.setTransportationDistance(decryptedResponse.getActualDist());
//        }
//        map.put("ewbDetails", ewbDetails);
//        map.put("genStatus", genStatus);
//        return map;
//    }
}
