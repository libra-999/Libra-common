package org.project.commons.enums;

import lombok.Getter;

public enum GatewayType {

    SERVICE_DOWN (10001,"Service unavailable"),
    LIMIT_TIMEOUT(10002,"Service is timeout"),
    OVER_LOAD(10003,"Service overload"),
    BAD_GATEWAY(10004,"Service unknown in product"),
    MAINTENANCE(10005,"Service maintenance");

    @Getter
    private final int code;
    @Getter
    private final String value;
    GatewayType(int code, String value) {
        this.code = code;
        this.value = value;
    }

}
