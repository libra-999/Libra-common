package com.common.commoncapcha.service;

import java.io.Serializable;

public interface CodeService extends Serializable {

    String generateCaptcha();

    boolean verifyCaptcha(String defaultCode, String userInputCode);

}
