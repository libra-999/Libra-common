package com.common.capcha;


import cn.hutool.captcha.CaptchaUtil;
import com.common.commoncapcha.context.LineCaptcha;
import com.common.commoncapcha.provider.CaptchaProvider;
import org.junit.jupiter.api.Test;

public class LineCaptchaTest {

    @Test
    public void generateCode(){
        LineCaptcha captchaUtil = CaptchaProvider.createLineCaptcha(15,15);
        cn.hutool.captcha.LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(15,15);

        lineCaptcha.getCode();
//        captchaUtil.createCodeCaptcha(); // generate code
        System.out.println(captchaUtil.getCode());
    }
}
