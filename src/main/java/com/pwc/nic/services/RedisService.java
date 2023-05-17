package com.pwc.nic.services;

public interface RedisService {

    boolean tokenValidator(String token, Integer customerId);
}
