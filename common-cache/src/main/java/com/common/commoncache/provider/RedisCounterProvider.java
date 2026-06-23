package com.common.commoncache.provider;

public interface RedisCounterProvider {

    Long increment(String key, long delta);

    Long decrement(String key, long delta);

}
