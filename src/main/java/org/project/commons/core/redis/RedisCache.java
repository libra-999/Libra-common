package org.project.commons.core.redis;

import com.alibaba.fastjson2.JSON;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.formula.functions.T;
import org.project.commons.core.service.RedisService;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class RedisCache implements RedisService {

    private final StringRedisTemplate template;

    @Override
    public void deleteObject(Collection collection) {
        template.delete(collection);
    }

    public void setCacheObject(String key, Object value, long ttl) {
        String json = JSON.toJSONString(value);
        if (ttl > 0) {
            template.opsForValue().set(key, json, ttl, TimeUnit.SECONDS);
        } else {
            template.opsForValue().set(key, json);
        }
    }

    public void setCacheObject(String key, Object value) {
        setCacheObject(key, value, 0);
    }

    @Override
    public Object getCacheObject(String key) {
        return template.opsForValue().get(key);
    }

    @Override
    public void publish(String channel, String message) {
        template.convertAndSend(channel, message);
    }

    @Override
    public void delete(String channel) {
        template.delete(channel);
    }

    @Override
    public String getValue(String channel) {
        ValueOperations<String, String> valueOperations = template.opsForValue();
        return valueOperations.get(channel);
    }

    @Override
    public void setValue(String channel, String value, long time, TimeUnit timeUnit) {
        ValueOperations<String, String> valueOperations = template.opsForValue();
        valueOperations.set(channel, value, time, timeUnit);
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
        template.expire(key, time, timeUnit);
    }

    @Override
    public Long add(List<T> datas, String key) {
        SetOperations<String, String> operations = template.opsForSet();
        long length = 0L;
        for (T data : datas)
            length += operations.add(key, data.toString());
        return length;
    }

    @Override
    public Long increment(String key) {
        return template.opsForValue().increment(key);
    }

    @Override
    public Set<String> topPlayer(String channel, int topNumber) {
        ZSetOperations<String, String> operations = template.opsForZSet();
        return operations.reverseRange(channel, 0, topNumber - 1);
    }

    @Override
    public Double score(String channel, String user) {
        ZSetOperations<String, String> operations = template.opsForZSet();
        return operations.score(channel, user);
    }

    @Override
    public Long rank(String channel, String userId) {
        ZSetOperations<String, String> operations = template.opsForZSet();
        return operations.reverseRank(channel, userId);
    }

    @Override
    public void addToZSet(String channel, String member, int score) {
        ZSetOperations<String, String> operations = template.opsForZSet();
        operations.add(channel, member, score);
    }

    public Collection<String> keys(final String pattern) {
        return template.keys(pattern);
    }

}
