package com.common.commonutil.color;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;

import java.util.List;

public class Color {

    public static java.awt.Color getColor(String color) {
        if (StrUtil.isBlank(color)) return null;

        String colorName = color.toUpperCase();
        switch (colorName) {
            case "BLACK":
                return java.awt.Color.BLACK;
            case "BLUE":
                return java.awt.Color.BLUE;
            case "CYAN":
                return java.awt.Color.CYAN;
            case "GRAY":
                return java.awt.Color.GRAY;
            case "GREEN":
                return java.awt.Color.GREEN;
            case "LIGHT_GRAY":
                return java.awt.Color.LIGHT_GRAY;
            case "MAGENTA":
                return java.awt.Color.MAGENTA;
            case "ORANGE":
                return java.awt.Color.ORANGE;
            case "PINK":
                return java.awt.Color.PINK;
            case "RED":
                return java.awt.Color.RED;
            case "WHITE":
                return java.awt.Color.WHITE;
            case "YELLOW":
                return java.awt.Color.YELLOW;
            default: {
                List<String> rgb = StrUtil.split(colorName, ",");
                if (rgb.size() == 3) {
                    Integer r = Convert.toInt(rgb.get(0));
                    Integer g = Convert.toInt(rgb.get(1));
                    Integer b = Convert.toInt(rgb.get(2));
                    if (!ArrayUtil.hasNull(r, g, b)) {
                        return new java.awt.Color(r, g, b);
                    }
                } else return null;
            }

        }
        return null;
    }

}
