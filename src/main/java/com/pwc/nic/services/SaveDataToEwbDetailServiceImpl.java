package com.pwc.nic.services;

import com.pwc.nic.model.EwbDetails;
import com.pwc.nic.repository.EwbDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Timestamp;

@Service
public class SaveDataToEwbDetailServiceImpl implements SaveDataToEwbDetailService {

    @Autowired
    EwbDetailsRepository ewbDetailsRepository;

    @Autowired
    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean;

    @Override
    public void saveData(EwbDetails ewbDetails) {
        ewbDetails.setNicExtendedTimes(0);
        ewbDetails.setNicValidDays(0);
        ewbDetails.setTotalValue(0.00f);
        ewbDetails.setCgstValue(0.00f);
        ewbDetails.setSgstValue(0.00f);
        ewbDetails.setIgstValue(0.00f);
        ewbDetails.setCessValue(0.00f);
        ewbDetails.setTaxableAmount(0.00f);
        ewbDetails.setTaxableValue(0.00f);
        ewbDetails.setMisAction("GETBYDOC");
        ewbDetailsRepository.save(ewbDetails);
    }
}
