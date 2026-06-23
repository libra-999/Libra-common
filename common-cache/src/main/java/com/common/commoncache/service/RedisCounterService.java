package com.common.commoncache.service;

import com.common.commoncache.provider.RedisCounterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisCounterService implements RedisCounterProvider {

    @Autowired
    private StringRedisTemplate template;

    @Override
    public Long increment(String key, long delta) {
        if (delta > 0) {
            return template.opsForValue().increment(key, delta);
        } else {
            return template.opsForValue().increment(key);
        }
    }

    @Override
    public Long decrement(String key, long delta) {
        if (delta > 0) {
            return template.opsForValue().decrement(key, delta);
        } else {
            return template.opsForValue().decrement(key);
        }
    }

}
