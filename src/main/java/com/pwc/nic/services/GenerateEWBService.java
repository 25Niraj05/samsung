package com.pwc.nic.services;

import com.pwc.nic.model.EwbDetails;
import com.pwc.nic.util.ApiResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;

public interface GenerateEWBService {
    JSONObject generateOnlyEWB(ApiResponse authRes, String payload, EwbDetails ewbDetails) throws JSONException;
}
