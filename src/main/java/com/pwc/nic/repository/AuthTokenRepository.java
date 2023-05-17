package com.pwc.nic.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pwc.nic.model.AuthToken;

@Repository
public interface AuthTokenRepository extends CrudRepository<AuthToken, String> {

}
