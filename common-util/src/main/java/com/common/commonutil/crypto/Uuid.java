package com.common.commonutil.crypto;


import cn.hutool.core.lang.UUID;

public class Uuid {

    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }

    public static String randomUUID(int length) {
        return UUID.randomUUID().toString().substring(0, length);
    }

    public static String randomSimpleUUID() {
        return UUID.randomUUID().toString(true);
    }

    public static String randomSimpleUUID(int length) {
        return UUID.randomUUID().toString(true).substring(0, length);
    }

    public static String fastRandomUUID() {
        return UUID.fastUUID().toString();
    }

    public static String fastRandomUUID(int length) {
        return UUID.fastUUID().toString().substring(0, length);
    }

    public static String fastSimpleUUID() {
        return UUID.fastUUID().toString(true);
    }

    public static String fastSimpleUUID(int length) {
        return UUID.fastUUID().toString(true).substring(0, length);
    }

}
