package org.project.commons.exception.user;

import org.springframework.http.HttpStatus;

public class CaptchaExpireException extends UserException
{
    public CaptchaExpireException() {
        super("user.captcha.expire", HttpStatus.BAD_GATEWAY, null);
    }
}
