package org.project.commons.enums;

import lombok.Getter;

public enum UserStatus {
    OK("0", "normal"),
    DISABLE("1", "disable"),
    DELETED("2", "delete");

    @Getter
    private final String code;

    @Getter
    private final String info;

    UserStatus(String code, String info) {
        this.code = code;
        this.info = info;
    }
}
