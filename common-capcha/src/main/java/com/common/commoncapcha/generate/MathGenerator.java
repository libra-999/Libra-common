package com.common.commoncapcha.generate;

import cn.hutool.core.math.Calculator;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.common.commoncapcha.service.CodeService;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class MathGenerator implements CodeService {

    private int numLength ;

    @Override
    public String generateCaptcha() {
        int limit = Integer.parseInt("1" + StrUtil.repeat("0", this.numLength));
        String number1 = Integer.toString(RandomUtil.randomInt(limit));
        String number2 = Integer.toString(RandomUtil.randomInt(limit));
        number1 = StrUtil.padAfter(number1,numLength, " ");
        number2 = StrUtil.padAfter(number2,numLength, " ");
        return StrUtil.builder().append(number1).append(RandomUtil.randomChar("+-*")).append(number2).append("=").toString();

    }

    @Override
    public boolean verifyCaptcha(String defaultCode, String userInputCode) {
        int result;
        try {
            result = Integer.parseInt(userInputCode);
        }catch (Exception e){
            return false;
        }

        int calResult = (int) Calculator.conversion(defaultCode);
        return result == calResult;
    }



}
