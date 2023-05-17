package com.pwc.nic.repository;

import com.pwc.nic.model.GSTINMasterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import static com.pwc.nic.util.Constants.GSTIN;

@Repository
public interface GSTINMasterRepository extends JpaRepository<GSTINMasterEntity, Long> {

//	@Query(value = "select * from ewb_cusdb.demo.gstin_master where gstin like :gstin and " +
//		"active='Y'", nativeQuery = true)
	@Query(value = "select * from demo.gstin_master where gstin like :gstin and " +
		"active='Y'", nativeQuery = true) //SwitchSamsungDB
	GSTINMasterEntity findByGSTINAndActive(@Param(GSTIN) String gstin);
}
