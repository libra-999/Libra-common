package com.common.commoncache.service;

import com.common.commoncache.provider.RedisListenProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisListenService implements RedisListenProvider {

    private final Logger log = LoggerFactory.getLogger(RedisListenService.class);

    @Autowired
    private StringRedisTemplate template;


    @Override
    public void publish(String channel, String message) {
        log.warn("==> Channel: {}", channel);
        template.convertAndSend(channel, message);
    }

}
