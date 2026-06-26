package com.common.commonutil.date;

import com.common.commonutil.constant.DateFormatConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.ManagementFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;


public class Date {

    private static final Logger logger = LoggerFactory.getLogger(Date.class);

    public static java.util.Date getNowDate() {
        return new java.util.Date();
    }

    public static String getDateFormat() {
        return dateTimeNow(DateFormatConstant.YEAR);
    }


    public static String getDateTimeFormat() {
        return dateTimeNow(DateFormatConstant.FULL_DATE_TIME);
    }

    // with current timezone server
    public static String dateTimeNow(final String format) {
        return parseDateToStr(format, new java.util.Date());
    }

    // manual timezone
    public static String dateTime(final java.util.Date date) {
        return parseDateToStr(DateFormatConstant.YEAR_MONTH_DAY, date);
    }

    public static String parseDateToStr(final String format, final java.util.Date date) {
        logger.info("==> Format: {}", format);
        return new SimpleDateFormat(format).format(date);
    }

    //    display current date in server
    public static java.util.Date getServerStartDate() {
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new java.util.Date(time);
    }

    //    calculate different time in a  day , ex: 2022-12-22 00:00:00 2022-12-24 01:00:00 => result = 1 day
    public static int getDayByDifferentMillisecond(java.util.Date date1, java.util.Date date2) {
        // 1s = 1000 ms
        // 1min = 1000ms * 60
        // 1 day = 1000ms * 60 * 60 * 24
        return Math.abs((int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24)));
    }

    public static boolean verifiedDateFormat(final String format, final String dateValueStr) {
        try {
            new SimpleDateFormat(format).parse(dateValueStr);
            return true;
        } catch (ParseException e) {
            logger.error("==> Invalid Format");
            return false;
        }
    }

    //    convert localDateTime to Date
    public static java.util.Date toDate(LocalDateTime temporalAccessor) {
        ZonedDateTime zdt = temporalAccessor.atZone(ZoneId.systemDefault());
        return java.util.Date.from(zdt.toInstant());
    }

    //    convert localDate to Date
    public static java.util.Date toDate(LocalDate temporalAccessor) {
        LocalDateTime localDateTime = LocalDateTime.of(temporalAccessor, LocalTime.of(0, 0, 0));
        return toDate(localDateTime);
    }


}
