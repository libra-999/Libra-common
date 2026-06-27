package com.common.commoncapcha.generate;

import cn.hutool.core.math.Calculator;
import cn.hutool.core.util.CharUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.common.commoncapcha.service.CodeService;
import com.common.commonutil.constant.PatternConstant;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class MathGenerator implements CodeService {

    private final int numLength ;
    private final boolean hasNegative;

    @Override
    public String generateCaptcha() {
        int limit = Integer.parseInt("1" + StrUtil.repeat("0", this.numLength));
        char operator = RandomUtil.randomChar(PatternConstant.BASE_OPERATION);
        int num1;
        int num2;
        num1 = RandomUtil.randomInt(limit);
        if (!hasNegative && CharUtil.equals('-', operator ,false)){
            num2 = num1 == 0 ? 0: RandomUtil.randomInt(0,limit);
        }else {
            num2 = RandomUtil.randomInt(limit);
        }

        String number1 = Integer.toString(num1);
        String number2 = Integer.toString(num2);
        number1 = StrUtil.padAfter(number1,numLength, " ");
        number2 = StrUtil.padAfter(number2,numLength, " ");
        return StrUtil.builder().append(number1).append(RandomUtil.randomChar(PatternConstant.BASE_OPERATION)).append(number2).append("=").toString();
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
