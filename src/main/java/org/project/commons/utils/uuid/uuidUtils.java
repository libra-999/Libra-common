package org.project.commons.utils.uuid;

import java.util.UUID;

public class uuidUtils {

    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }

    public static String simpleUUID() {
        return UUID.randomUUID().toString();
    }

    public static String fastRandomUUID() {
        return cn.hutool.core.lang.UUID.fastUUID().toString();
    }

    public static String fastSimpleUUID() {
        return cn.hutool.core.lang.UUID.fastUUID().toString(true);
    }
}
