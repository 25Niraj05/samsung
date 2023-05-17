package com.pwc.nic.services;

import com.pwc.nic.model.EwbDetails;
import com.pwc.nic.util.ApiResponse;

public interface EwbDetailService {
    void saveData(EwbDetails ewbDetails);

    EwbDetails getData(EwbDetails ewbDetails);
}
