package com.common.commoncache.service;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.common.commoncache.provider.RedisHTTPProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class RedisHTTPService implements RedisHTTPProvider {

    private final Logger log = LoggerFactory.getLogger(RedisHTTPService.class);

    @Autowired
    private StringRedisTemplate template;

    @Override
    public void setCacheObject(String key, Object value, long ttl) {
        String json = JSONUtil.toJsonStr(value);
        if (ttl > 0) {
            template.opsForValue().set(key, json, ttl, TimeUnit.SECONDS);
        } else {
            template.opsForValue().set(key, json);
        }
    }

    @Override
    public void setCacheObject(String key, Object value) {
        setCacheObject(key, value, 0);
    }

    @Override
    public void setCacheObject(String key, Object value, long ttl, TimeUnit timeUnit) {
        String json = JSONUtil.toJsonStr(value);
        ValueOperations<String, String> valueOperations = template.opsForValue();
        valueOperations.set(key, json, ttl, timeUnit);
    }

    @Override
    public void delete(String channel) {
        template.delete(channel);
    }

    @Override
    public void deleteList(Collection<Object> collection) {
        template.delete(collection.toString());
    }

    @Override
    public Object getCacheObject(String key) {
        return template.opsForValue().get(key);
    }

    @Override
    public List<Object> getListCaches(List<String> keys){
        List<String> strCache = template.opsForValue().multiGet(keys);
        List<Object> objs = new ArrayList<>();
        for (String obj: strCache){
            if (Objects.nonNull(obj)){
                JSON bean = JSONUtil.parseObj(obj);
                objs.add(bean);
            }
        }
        return objs;
    }


    @Override
    public Map<String, String> hash(String channel) {
        HashOperations<String, String, String> hashOperations = template.opsForHash();
        return hashOperations.entries(channel);
    }

    @Override
    public void putHash(String channel, String key, String value) {
        HashOperations<String, String, String> hashOperations = template.opsForHash();
        hashOperations.put(channel, key, value);
    }

    @Override
    public String hash(String channel, String key) {
        HashOperations<String, String, String> hashOperations = template.opsForHash();
        return hashOperations.get(channel, key);
    }

    @Override
    public void hashDelete(String channel, String key) {
        HashOperations<String, String, String> hashOperations = template.opsForHash();
        hashOperations.delete(channel, key);
    }

    @Override
    public void hashDeleteAll(String channel, Set<String> keys) {
        for (String key : keys)
            hashDelete(channel, key);
    }

    @Override
    public void expire(String key, Long time, TimeUnit timeUnit) {
        log.warn("Key: {}, Date: {}",  key,  new Date());
        template.expire(key, time, timeUnit);
    }

    @Override
    public void expiredWithDate(String key, Date date) {
        log.warn("Key: {}, Date: {}",  key,  new Date());
        template.expireAt(key, date);
    }

    @Override
    public Long set(List<Object> datas, String key) {
        SetOperations<String, String> operations = template.opsForSet();
        long length = 0L;
        for (Object data : datas) {
            length += Objects.requireNonNull(operations.add(key, data.toString()));
        }
        return length;
    }

    public Collection<String> getAllChannels(final String pattern) {
        return template.keys(pattern);
    }

    @Override
    public Boolean existKey(String key) {
        return template.hasKey(key);
    }

}
