package com.common.commoncache.provider;


import java.util.*;
import java.util.concurrent.TimeUnit;

public interface RedisHTTPProvider {

    void deleteList(Collection<Object> collection);

    Object getCacheObject(final String key);

    List<Object> getListCaches(final List<String> keys);

    void setCacheObject(String key, Object value, long ttl, TimeUnit timeUnit);

    void setCacheObject(String key, Object value, long ttl);

    void setCacheObject(String key, Object value);

    void delete(String channel);

    Map<String, String> hash(String channel);

    void putHash(String channel, String key, String value);

    String hash(String channel, String key);

    void hashDelete(String channel, String key);

    void hashDeleteAll(String channel, Set<String> key);

    void expire(String key, Long time, TimeUnit timeUnit);

    void expiredWithDate(String key, Date date);

    Long set(List<Object> data, String key);

    Collection<String> getAllChannels(final String pattern);

    Boolean existKey (String key);
}
