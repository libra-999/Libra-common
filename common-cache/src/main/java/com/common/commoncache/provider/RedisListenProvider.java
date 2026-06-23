package com.common.commoncache.provider;

public interface RedisListenProvider {

    void publish(String channel, String message);

}
