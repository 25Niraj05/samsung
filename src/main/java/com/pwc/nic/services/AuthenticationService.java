package com.pwc.nic.services;
import com.pwc.nic.util.ApiResponse;

public interface AuthenticationService {

	ApiResponse authenticate(String gstin, String userName, String password, Integer customerid, String is_live) throws Exception;
}
