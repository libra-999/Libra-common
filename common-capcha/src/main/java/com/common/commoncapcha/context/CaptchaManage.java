package com.common.commoncapcha.context;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.io.IoUtil;
import com.common.commoncapcha.service.CaptchaService;
import com.common.commoncapcha.service.CodeService;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

@Getter
@Setter
public abstract class CaptchaManage implements CaptchaService {

    protected int width;
    protected int height;
    protected Font font;
    protected int length;
    protected String code;
    protected byte[] imageBytes;
    protected Color background = Color.WHITE; // default background
    protected Stroke stroke; // unformal text instead of normal text
    protected AlphaComposite text; // transparent output of text

    protected abstract Image imageCode(String code);

    protected CodeService codeGenerate;

    CaptchaManage(int width , int height, Font font , CodeService generator){
        this.width = width;
        this.height = height;
        this.font = font;
        this.codeGenerate = generator;
    }

    @Override
    public void createCodeCaptcha() {
        // call generateCode
        this.generateCode();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImgUtil.writePng(imageCode(this.code), byteArrayOutputStream);

        System.out.println("==> Image size: " + byteArrayOutputStream.size());
        this.imageBytes = byteArrayOutputStream.toByteArray();
    }

    protected void generateCode() {
        try {
            this.code = codeGenerate.generateCaptcha();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getCodeCaptcha() {
        if (this.code == null) {
            System.out.println("==> Code has been null so please generate code again");
            createCodeCaptcha(); // if code is null
        }
        return this.code;
    }

    @Override
    public boolean verifyCodeCaptcha(String userInputCode) {
        return this.codeGenerate.verifyCaptcha(getCodeCaptcha(), userInputCode);
    }

    public byte[] getImageBytes() {
        if (imageBytes == null) {
            createCodeCaptcha();
        }
        return this.imageBytes;
    }

    @Override
    public void write(OutputStream outputStream) {
        IoUtil.write(outputStream, false, getImageBytes());
    }

    public String getCode() {
        if (this.code == null){
            this.generateCode();
        }
        return this.code;
    }

}
