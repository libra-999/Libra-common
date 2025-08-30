package org.project.commons.exception.user;

import org.springframework.http.HttpStatus;

public class CaptchaException extends UserException
{
    public CaptchaException(String module, HttpStatus status, String message) {
        super("user.captcha.error", HttpStatus.BAD_REQUEST, null);
    }
}
