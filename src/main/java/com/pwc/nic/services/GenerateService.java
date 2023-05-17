package com.pwc.nic.services;

import org.json.JSONException;
import org.json.JSONObject;

public interface GenerateService {

	JSONObject generateEInvoice(JSONObject authResponse, JSONObject request, String gstin) throws Exception ;

    JSONObject setB2CData(JSONObject object) throws JSONException;

    JSONObject generateEwbByIrn(JSONObject authResponse, JSONObject request, String gstin) throws Exception ;
}
