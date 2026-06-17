package org.project.commons.enums;

import lombok.Getter;

public enum UserStatus {
    OK(1, "normal"),
    DISABLE(0, "disable"),
    DELETED(-1, "delete");

    @Getter
    private final int code;

    @Getter
    private final String info;

    UserStatus(int code, String info) {
        this.code = code;
        this.info = info;
    }
}
