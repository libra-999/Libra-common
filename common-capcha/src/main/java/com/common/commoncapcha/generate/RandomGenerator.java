package com.common.commoncapcha.generate;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;

public class RandomGenerator extends CodeGeneratorManage{

    public RandomGenerator(String str , int count) {
        super(str, count);
    }

    @Override
    public String generateCaptcha() {
        System.out.println("==> " + baseStr + "  " +length);
        return RandomUtil.randomString(this.baseStr, this.length);
    }

    @Override
    public boolean verifyCaptcha(String defaultCode, String userInputCode) {
        if (StrUtil.isNotBlank(userInputCode)){
            return StrUtil.equalsAnyIgnoreCase(defaultCode, userInputCode);
        }
        return false;
    }

}
