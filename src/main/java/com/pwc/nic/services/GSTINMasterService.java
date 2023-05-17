package com.pwc.nic.services;
import com.pwc.nic.model.EwbDetails;
import com.pwc.nic.model.GSTINMasterEntity;

import java.sql.SQLException;
import java.util.Map;

public interface GSTINMasterService {
	GSTINMasterEntity getGSTINMaster(String gstin);
}
