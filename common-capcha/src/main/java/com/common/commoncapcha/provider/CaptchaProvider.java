package com.common.commoncapcha.provider;


import com.common.commoncapcha.context.LineCaptcha;

import java.awt.*;

/**
 * Author: libra-999
 * This is key class to implement with another project
 * Just call 'CaptchaProvider'
 */
public class CaptchaProvider {

    public static LineCaptcha createLineCaptcha(int width, int height) {
        return new LineCaptcha(width,height);
    }

    public static LineCaptcha createLineCaptcha(int width, int height , Font font){
        return new LineCaptcha(width, height, font);
    }

    public static LineCaptcha createLineCaptcha(int width, int height , Font font , int codeLength){
        return new LineCaptcha(width,height,font, codeLength);
    }
}
