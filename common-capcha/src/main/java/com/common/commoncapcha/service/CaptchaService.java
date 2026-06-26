package com.common.commoncapcha.service;

import java.io.OutputStream;
import java.io.Serializable;

public interface CaptchaService extends Serializable {

    void createCodeCaptcha();

    String getCodeCaptcha();

    void write(OutputStream outputStream);

    boolean verifyCodeCaptcha(String codeCaptcha);

}
