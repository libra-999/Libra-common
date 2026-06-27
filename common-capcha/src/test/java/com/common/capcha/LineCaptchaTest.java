package com.common.capcha;


import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.common.commoncapcha.context.LineCaptcha;
import com.common.commoncapcha.generate.MathGenerator;
import com.common.commoncapcha.provider.CaptchaProvider;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LineCaptchaTest {

    @Test
    public void generateCode() {
        LineCaptcha captchaUtil = CaptchaProvider.createLineCaptcha(15, 15);
        captchaUtil.createCodeCaptcha();

        String code = captchaUtil.getCode();
        captchaUtil.verifyCodeCaptcha(code);
        Assert.isTrue(captchaUtil.verifyCodeCaptcha(code), "==> Incorrect code");
    }

    @Test
    public void mathGenerateCode() {
        MathGenerator math = new MathGenerator(2, true);
        String mathQue = math.generateCaptcha();
        if (StrUtil.isNotBlank(mathQue)) {
            LineCaptcha lineCaptcha = new LineCaptcha(15, 15);
            lineCaptcha.setCode(mathQue);

//            System.out.println("==> Question: [ " + mathQue + " ]");
            if (lineCaptcha.getCode() != null) {
                String[] number = mathQue.split("[-+*=]");
                String[] operation = Arrays.stream(mathQue.split("[\\d=]")).filter(s -> !s.isEmpty()).toArray(String[]::new);

                int order1 = Integer.parseInt(number[0].trim());
                int order2 = Integer.parseInt(number[1].trim());
                String operator = operation[0];
                int result = switch (operator) {
                    case "+" -> order1 + order2;
                    case "-" -> order1 - order2;
                    case "*" -> order1 * order2;
                    default -> 0;
                };

                lineCaptcha.setCode(String.valueOf(result));
                Assert.isTrue(math.verifyCaptcha(lineCaptcha.getCode(), String.valueOf(result)), "==> Verify result is incorrect");

            }
        }
    }

}
