package com.pwc.nic.services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import org.springframework.stereotype.Service;
@Service
public class RedisServiceImpl implements RedisService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisServiceImpl.class);

    @Autowired
    private RedisTemplate<String, String> template;

    @Override
    public boolean tokenValidator(String token, Integer customerId) {
        return String.valueOf(token)
                .equals((String) template.opsForHash().get(customerId + "#token", customerId + "#token"));
    }

  }
