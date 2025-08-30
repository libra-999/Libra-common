package org.project.commons.exception.user;

import org.springframework.http.HttpStatus;

public class BlackListException extends UserException {

    public BlackListException(String module, HttpStatus status, String message) {
        super("login.blocked", HttpStatus.FORBIDDEN, null);
    }
}
