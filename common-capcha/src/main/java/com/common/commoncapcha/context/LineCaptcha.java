package com.common.commoncapcha.context;

import cn.hutool.core.img.GraphicsUtil;
import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.util.RandomUtil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class LineCaptcha extends CaptchaManage {


    private static final int DEFAULT_LENGTH = 6;

    public LineCaptcha(int width, int height) {
        this(width, height, new Font(Font.MONOSPACED, Font.BOLD, (int) (height * 0.75)));
    }

    public LineCaptcha(int width, int height, Font font) {
        this(width, height, font, DEFAULT_LENGTH);
    }

    public LineCaptcha(int width, int height, Font font, int codeLength) {
        super(width, height, font, codeLength);
    }

    @Override
    protected Image imageCode(String code) {
        BufferedImage image = new BufferedImage(width, height, (Objects.isNull(this.background)) ? BufferedImage.TYPE_4BYTE_ABGR : BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = ImgUtil.createGraphics(image, background);
        try {
            drawInterfere(g2d);
            drawString(g2d, code);
        } catch (Exception e) {

            System.out.println(e.getMessage());
        } finally {
            g2d.dispose();
        }
        return image;
    }

    private void drawString(Graphics2D gp2D, String code) {
        if (Objects.nonNull(this.text)) {
            gp2D.setComposite(this.text);
        }

        GraphicsUtil.drawStringColourful(gp2D, code, this.font, this.width, this.height);
    }

    private void drawInterfere(Graphics2D gp2D) {
        if (Objects.nonNull(this.stroke)) {
            gp2D.setStroke(this.stroke);
        }
        ThreadLocalRandom random = RandomUtil.getRandom();
        for (int i = 0; i < this.length; i++) {
            int xs = random.nextInt(this.width);
            int ys = random.nextInt(this.height);
            int xe = xs + random.nextInt(this.width / 8);
            int ye = ys + random.nextInt(this.height / 8);

            gp2D.setColor(ImgUtil.randomColor(random));
            gp2D.drawLine(xs, ys, xe, ye);
        }
    }

}
