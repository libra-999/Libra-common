package com.common.commoncapcha.generate;

import com.common.commoncapcha.service.CodeService;
import com.common.commonutil.constant.PatternConstant;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class CodeGeneratorManage implements CodeService {

    protected final String baseStr; // random character in str
    protected final int length;

    public CodeGeneratorManage(int count) {
        this(PatternConstant.BASE_CHAR_NUM, count);
    }

    public CodeGeneratorManage(String baseStr, int count) {
        this.baseStr = baseStr;
        this.length = count;
    }
}
