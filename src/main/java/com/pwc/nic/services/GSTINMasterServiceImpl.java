package com.pwc.nic.services;
import com.pwc.nic.model.EwbDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwc.nic.model.GSTINMasterEntity;
import com.pwc.nic.repository.GSTINMasterRepository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Service
public class GSTINMasterServiceImpl implements GSTINMasterService {

	@Autowired(required = true)
	GSTINMasterRepository gSTINMasterRepository;

	@Autowired
	DataSource dataSource;

	@Override
	public GSTINMasterEntity getGSTINMaster(String gstin) {
		return gSTINMasterRepository.findByGSTINAndActive(gstin);
	}
}
