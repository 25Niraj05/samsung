package com.pwc.nic.repository;

import com.pwc.nic.model.EwbDetails;
import org.springframework.data.repository.CrudRepository;

public interface EwbDetailsRepository extends CrudRepository<EwbDetails, Integer> {
    EwbDetails findByDocNoAndEwbActiveAndUserGstin(String documentNumber, String active, String userGstin);
}
