package com.common.commonutil.constant;

public class PatternConstant {

    public static final String FILENAME_PATTERN = "[a-zA-Z0-9_\\-\\|\\.\\u4e00-\\u9fa5]+"; // ex: files-report.txt ,image1.png
    public static final String REGX_0_255 = "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]\\d|\\d)";
    public static final String REGX_IP = "((" + REGX_0_255 + "\\.){3}" + REGX_0_255 + ")";
    public static final String REGX_IP_WILDCARD = "(((\\*\\.){3}\\*)|(" + REGX_0_255 + "(\\.\\*){3})|(" + REGX_0_255 + "\\." + REGX_0_255 + ")(\\.\\*){2}" + "|((" + REGX_0_255 + "\\.){3}\\*))";
    public static final String REGX_IP_SEG = "(" + REGX_IP + "\\-" + REGX_IP + ")";
    public static final String BASE_CHAR = "abcdefghijklmnopqrstuvwxyz";
    public static final String BASE_NUMBER = "0123456789";
    public static final String BASE_CHAR_NUM = BASE_CHAR + BASE_NUMBER;

}
