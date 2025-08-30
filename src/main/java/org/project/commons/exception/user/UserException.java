package org.project.commons.exception.user;

import org.project.commons.exception.base.BaseException;
import org.springframework.http.HttpStatus;

public class UserException extends BaseException {

    public UserException(String module, HttpStatus status, String message) {
        super("user", status, message);
    }

    public static UserException NotFound() {
        return new UserException("user.not.found", HttpStatus.NOT_FOUND, "user not found");
    }

    public static UserException AlreadyExist() {
        return new UserException("user.exist", HttpStatus.CONFLICT, "user already exist");
    }

    public static UserException PasswordNotMatch() {
        return new UserException("user.password", HttpStatus.BAD_REQUEST, "password not match");
    }

    public static UserException PasswordRetryLimitExceed() {
        return new UserException("password.retry.limit.exceed", HttpStatus.BAD_REQUEST, null);
    }
}
