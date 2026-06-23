package com.common.commonutil.constant;

import java.util.List;

public class DateFormatConstant {

    public static final String YEAR = "yyyy";
    public static final String MONTH = "MM";
    public static final String DAY = "dd";
    public static final String TIME = "HH:mm:ss";
    public static final String YEAR_MONTH = "yyyy-MM";
    public static final String YEAR_MONTH_DAY = "yyyy-MM-dd";
    public static final String FULL_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final List<String> PATTERNS = List.of(
        "yyyy/MM/dd",
        "yyyy/MM/dd HH:mm:ss",
        "yyyy MM dd",
        "yyyy MM dd HH:mm:ss",
        "yyyy.MM.dd HH:mm:ss",
        "yyyy.MM.dd");

}
