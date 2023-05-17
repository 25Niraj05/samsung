package com.pwc.nic.services;

import com.pwc.nic.model.EwbDetails;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ConcurrentHashMap;

public interface ProcessPayloadService {

    ConcurrentHashMap<String, String> createEWBPayload();

    JSONObject setDocDetailPayload(JSONObject data, JSONObject docDetails) throws JSONException;

    JSONObject setSellerDetailPayload(JSONObject data, JSONObject docDetails) throws JSONException;

    JSONObject setBuyerDetailPayload(JSONObject data, JSONObject buyerDtls) throws JSONException;

    JSONObject setValueDetailPayload(JSONObject data, JSONObject valDtls) throws JSONException;

    JSONObject setDispDetailPayload(JSONObject data, JSONObject dispDtls) throws  JSONException;

    JSONObject setShippingDetails(JSONObject data, JSONObject shipDtls) throws JSONException;

    JSONObject setEwbDetails(JSONObject data, JSONObject ewbDtls) throws JSONException;

    JSONObject setItemDetails(JSONObject item) throws JSONException;

    EwbDetails hardCodeValues(EwbDetails ewbDetails);
}
