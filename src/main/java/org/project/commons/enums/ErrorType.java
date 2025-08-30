package org.project.commons.enums;

import lombok.Getter;

@Getter
public enum ErrorType {

    ERROR("An unexpected error occurred"),
    UNKNOWN_ERROR("Unknown error occurred"),
    VALIDATION_ERROR("Validation error"),
    UNAUTHORIZED("Unauthorized"),
    AUTHENTICATION("Authentication failed");

    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

}
