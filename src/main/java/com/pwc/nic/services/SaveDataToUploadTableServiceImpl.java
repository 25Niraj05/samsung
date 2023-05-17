package com.pwc.nic.services;

import com.pwc.nic.model.EwbDetails;
import com.pwc.nic.model.Upload;
import com.pwc.nic.repository.UploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

import static com.pwc.nic.util.Constants.API;
import static com.pwc.nic.util.Constants.N;

@Service
public class SaveDataToUploadTableServiceImpl implements SaveDataToUploadTableService{

    @Autowired
    UploadRepository uploadRepository;

    @Override
    public void saveData(EwbDetails ewbDetails) {
        Upload upload = new Upload();
        upload.setLoadId(ewbDetails.getLoadId());
        upload.setActive(N);
        upload.setSourceSystem(API);
        upload.setCompanyId(ewbDetails.getCompanyId());
        upload.setCompanyName(ewbDetails.getCompanyName());
        upload.setState(" ");
        upload.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        upload.setCreatedBy("Admin");
        upload.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        upload.setUpdatedBy("Admin");
        upload.setCategory("EWB Generation");
        upload.setComments(" Load Id Created by Generate API");
        upload.setDataType("EWB_Details");
        upload.setFailedQuality(0);
        upload.setImportFromFile(0);
        upload.setLoadType(API);
        upload.setMapping(API);
        upload.setOriginalFileName(API);
        upload.setS3FileName(API);
        upload.setFileName("Data Uploaded through EWB API@" + System.currentTimeMillis());
        upload.setStatus("Data successfully loaded");
        uploadRepository.save(upload);
    }
}
