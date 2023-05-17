package com.pwc.nic.services;

import org.json.JSONObject;

import java.util.concurrent.ConcurrentHashMap;

public interface GetEwayBillService {

//    ConcurrentHashMap<String, String> getEwayBill(JSONObject authResponse, String ewayBillNo) throws Exception;
//
//    ConcurrentHashMap<String, String> getEwbByDate(JSONObject authResponse, String date) throws Exception;

    ConcurrentHashMap<String, String> getEwbGenByConsignor(JSONObject authResponse, String docType, String docNo)
            throws Exception;

//    ConcurrentHashMap<String, String> getErrorList(JSONObject authResponse) throws Exception;
//
//    ConcurrentHashMap<String, String> getGstinDetails(JSONObject authResponse, String gstin) throws Exception;
}
