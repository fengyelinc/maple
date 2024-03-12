package com.cc.backend.common.utils;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import io.swagger.models.auth.In;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class LocalDateUtils {

    private static String[] parsePatterns = {"yyyy-MM-dd", "yyyy年MM月dd日",
            "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy/MM/dd",
            "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyyMMdd", "yyyy.MM.dd HH:mm", "yyyy.MM.dd"};


    /**
     * 将字符串转换为时间
     *
     * @param str
     * @return
     */
    public static LocalDateTime parseToDate(String str) {
        if (str == null) {
            return null;
        }

        DateTime dateTime = DateUtil.parse(str, parsePatterns);
        LocalDateTime localDateTime = dateTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        return localDateTime;
    }

    public static LocalDateTime addSecond(LocalDateTime date, int second) {
        return date.plusSeconds(second);
    }

    public static LocalDateTime minusSecond(LocalDateTime date, int second) {
        return date.minusSeconds(second);
    }

    public static LocalDateTime addMinute(LocalDateTime date, int minute) {
        return date.plusMinutes(minute);
    }

    public static LocalDateTime minusMinute(LocalDateTime date, int minute) {
        return date.minusMinutes(minute);
    }

    public static LocalDateTime addHour(LocalDateTime date, int hour) {
        return date.plusHours(hour);
    }

    public static LocalDateTime minusHour(LocalDateTime date, int hour) {
        return date.minusHours(hour);
    }

    public static LocalDateTime addDay(LocalDateTime date, int day) {
        return date.plusDays(day);
    }

    public static LocalDateTime minusDay(LocalDateTime date, int day) {
        return date.minusDays(day);
    }


    public static LocalDateTime addMonth(LocalDateTime date, int month) {
        return date.plusMonths(month);
    }

    public static LocalDateTime minusMonth(LocalDateTime date, int month) {
        return date.minusMonths(month);
    }

    public static LocalDateTime minusYear(LocalDateTime date, int year) {
        return date.minusYears(year);
    }

    /**
     * 获取当月第一天
     *
     * @return
     */
    public static String getFirstDayofMonth() {
        LocalDate now = LocalDate.now();
        LocalDate firstDayOfMonth = now.withDayOfMonth(1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return firstDayOfMonth.format(formatter);
    }

    /**
     * 获取当月最后一天
     *
     * @return
     */
    public static String getLastDayofMonth() {
        LocalDate now = LocalDate.now();
        // 获取当前月份的下一个月的第一天，并减去一天得到当月最后一天
        LocalDate lastDayOfMonth = now.with(TemporalAdjusters.firstDayOfNextMonth()).minusDays(1);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return lastDayOfMonth.format(formatter);
    }


    /**
     * 日期比较
     *
     * @param source
     * @param target
     * @return
     */
    public static Integer compareTo(LocalDate source, LocalDate target) {
        int result = source.compareTo(target);
        if (result < 0) {
            //source 在 target 之前
            return -1;
        } else if (result == 0) {
            // source 与 target 相同
            return 0;
        } else {
            //source 在 target 之后
            return 1;
        }
    }


    /**
     * 日期比较
     *
     * @param source
     * @param target
     * @return
     */
    public static Integer compareTo(LocalDateTime source, LocalDateTime target) {
        int result = source.compareTo(target);
        if (result < 0) {
            //source 在 target 之前
            return -1;
        } else if (result == 0) {
            // source 与 target 相同
            return 0;
        } else {
            //source 在 target 之后
            return 1;
        }
    }


    /**
     * 计算两个日期之间的差值（天数）
     *
     * @param source 源日期
     * @param target 目标日期
     * @return 相差的天数
     */
    public static long subtract(LocalDateTime source, LocalDateTime target) {
        long days = ChronoUnit.DAYS.between(source.toLocalDate(), target.toLocalDate());
        return days;
    }


    /**
     * 获取当前时间属于第几季度
     *
     * @param date
     * @return
     */
    public static int getQuarter(LocalDateTime date) {
        Month month = date.getMonth();

        if (month.getValue() <= 3) {
            return 1;
        } else if (month.getValue() <= 6) {
            return 2;
        } else if (month.getValue() <= 9) {
            return 3;
        } else {
            return 4;
        }
    }


    /**
     * 获取当前月份
     *
     * @param date
     * @return
     */
    public static int getMonth(LocalDateTime date) {
        Month month = date.getMonth();
        return month.getValue();
    }


    /**
     * 获取当前月份（中文）
     *
     * @param date
     * @return
     */
    public static String getChineseMouth(LocalDateTime date) {
        Month month = date.getMonth();
        int value = month.getValue();
        String[] chineseMonths = {"一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"};
        return chineseMonths[value];
    }


    /**
     * 获取当前年份
     *
     * @param date
     * @return
     */
    public static int getYear(LocalDateTime date) {
        int year = date.getYear();
        return year;
    }


    /**
     * 获取给定年份和月份的最后一天
     *
     * @param year  年份
     * @param month 月份（1-12）
     * @return 最后一天的日期
     */
    public static LocalDate getLastDayOfMonth(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate lastDayOfMonth = yearMonth.atEndOfMonth();
        return lastDayOfMonth;
    }


    /**
     * 获取给定年份和月份的第一天
     *
     * @param year  年份
     * @param month 月份（1-12）
     * @return 第一天的日期
     */
    public static LocalDate getFirstDayOfMonth(int year, int month) {
        LocalDate firstDayOfMonth = YearMonth.of(year, month).atDay(1);
        return firstDayOfMonth;
    }


    /**
     * 获取给定年份和季度的最后一天
     *
     * @param year    年份
     * @param quarter 季度（1-4）
     * @return 季度的最后一天的日期
     */
    public static LocalDate getLastDayOfQuarter(int year, int quarter) {
        // 确定季度最后一个月的第一天
        LocalDate firstDayOfLastMonthInQuarter = LocalDate.of(year, ((quarter - 1) * 3) + 3, 1);

        // 获取该季度的最后一天
        LocalDate lastDayOfQuarter = firstDayOfLastMonthInQuarter.with(TemporalAdjusters.lastDayOfMonth());

        return lastDayOfQuarter;
    }

    /**
     * 获取给定年份和季度的第一天
     *
     * @param year    年份
     * @param quarter 季度（1-4）
     * @return 季度的第一天的日期
     */
    public static LocalDate getFirstDayOfQuarter(int year, int quarter) {
        // 确定季度第一个月的第一天
        LocalDate firstDayOfQuarter = LocalDate.of(year, (quarter - 1) * 3 + 1, 1);

        return firstDayOfQuarter;
    }


    /**
     * 获取给定年份的第一天
     *
     * @param year 年份
     * @return 年份的第一天的日期
     */
    public static LocalDate getFirstDayOfYear(int year) {
        LocalDate firstDayOfYear = LocalDate.of(year, 1, 1);

        return firstDayOfYear;
    }


    /**
     * 获取给定年份的最后一天
     *
     * @param year 年份
     * @return 年份的最后一天的日期
     */
    public static LocalDate getLastDayOfYear(int year) {
        LocalDate lastDayOfYear = LocalDate.of(year, 12, 31).with(TemporalAdjusters.lastDayOfYear());

        return lastDayOfYear;
    }


    /**
     * 判断两个时间之间月份是否相差n个月
     *
     * @param source 源日期
     * @param target 目标日期
     * @return 如果相差一个月返回true，否则返回false
     */
    public static boolean isOneMonthDifference(LocalDateTime source, LocalDateTime target, Integer n) {
        LocalDate date1 = LocalDate.of(getYear(source), getMonth(source), 1);
        LocalDate date2 = LocalDate.of(getYear(target), getMonth(target), 1);

        long monthsBetween = ChronoUnit.MONTHS.between(date1, date2);
        return Math.abs(monthsBetween) == n;
    }


    /**
     * 判断两个时间是否处于同一月份
     *
     * @param source 源日期
     * @param target 目标日期
     * @return 如果处于同一月份返回true，否则返回false
     */
    public static boolean isSameMonth(LocalDateTime source, LocalDateTime target) {
        LocalDate date1 = LocalDate.of(getYear(source), getMonth(source), 1);
        LocalDate date2 = LocalDate.of(getYear(target), getMonth(target), 1);
        return date1.getMonthValue() == date2.getMonthValue();
    }


    /**
     * 判断两个时间之间季度是否相差1个季度
     *
     * @param source 源日期
     * @param target 目标日期
     * @return 如果相差一个季度返回true，否则返回false
     */
    public static boolean isOneQuarterDifference(LocalDateTime source, LocalDateTime target) {
        LocalDate date1 = LocalDate.of(getYear(source), getMonth(source), 1);
        LocalDate date2 = LocalDate.of(getYear(target), getMonth(target), 1);

        long monthsBetween = ChronoUnit.MONTHS.between(date1, date2);
        return Math.abs(monthsBetween) % 3 == 0 && Math.abs(monthsBetween) >= 3;
    }

    /**
     * 判断两个时间是否处于同一季度
     *
     * @param source 源日期
     * @param target 目标日期
     * @return 如果处于同一季度返回true，否则返回false
     */
    public static boolean isSameQuarter(LocalDateTime source, LocalDateTime target) {
        LocalDate date1 = LocalDate.of(getYear(source), getMonth(source), 1);
        LocalDate date2 = LocalDate.of(getYear(target), getMonth(target), 1);
        if(getYear(source)!=getYear(target)){
            return false;
        }

        int quarter1 = getQuarter(LocalDateTime.of(date1, LocalTime.MIDNIGHT));
        int quarter2 = getQuarter(LocalDateTime.of(date2, LocalTime.MIDNIGHT));

        return quarter1 == quarter2;
    }


    /**
     * 判断两个时间之间是否相差n年
     *
     * @param source 源日期
     * @param target 目标日期
     * @return 如果相差一年返回true，否则返回false
     */
    public static boolean isOneYearDifference(LocalDateTime source, LocalDateTime target, Integer n) {

        long yearsBetween = ChronoUnit.YEARS.between(source, target);
        return Math.abs(yearsBetween) == n;
    }


    /**
     * 获取下一个月的第一天
     *
     * @param source 源日期
     * @return 下一个月第一天的日期
     */
    public static LocalDateTime getNextMonthFirstDay(LocalDateTime source) {
        // 获取下一个月的第一天
        LocalDateTime nextMonthFirstDay = source.plusMonths(1).with(TemporalAdjusters.firstDayOfMonth());

        return nextMonthFirstDay;
    }


    /**
     * 获取某一天的开始时间
     *
     * @param source 源日期
     * @return 当天开始时间的LocalDateTime对象
     */
    public static LocalDateTime getBeginOfDay(LocalDateTime source) {

        // 设置时间为当天的开始时间（00:00:00.000）
        LocalDateTime beginningOfDay = source.with(LocalTime.MIN);

        System.out.println("当天开始时间：" + beginningOfDay);
        return beginningOfDay;
    }


    /**
     * 获取某一天的结束时间
     *
     * @param source 源日期
     * @return 当天开始时间的LocalDateTime对象
     */
    public static LocalDateTime getEndOfDay(LocalDateTime source) {

        // 设置时间为当天的结束时间（23:59:59.999）
        LocalDateTime endingOfDay = source.with(LocalTime.MAX);

        System.out.println("当天结束时间：" + endingOfDay);
        return endingOfDay;
    }


    /**
     * 获取下个季度的第一天（考虑到跨年）
     *
     * @param source 源日期
     * @return 下个季度第一天的LocalDateTime对象
     */
    public static LocalDateTime getNextQuarterFirstDay(LocalDateTime source) {
        int year = getYear(source);
        int quarter = getQuarter(source);
        LocalDate localDate = null;
        switch (quarter) {
            case 1:
                localDate = YearMonth.of(year, 4).atDay(1);
                break;
            case 2:
                localDate = YearMonth.of(year, 7).atDay(1);
                break;
            case 3:
                localDate = YearMonth.of(year, 10).atDay(1);
                break;
            case 4:
                localDate = YearMonth.of(year + 1, 1).atDay(1);
                break;
        }
        return LocalDateTime.of(localDate, LocalTime.MIDNIGHT);
    }

    public static void main(String[] args) {
//        String a = "2024-10-01 12:34:56";
//        String b = "2026-10-01 12:34:56";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime localDateTimeA = LocalDateTime.parse(a, formatter);
//        LocalDateTime localDateTimeB = LocalDateTime.parse(b, formatter);
        String a = "2024-10-01";
        String b = "2026-10-01";
//        LocalDateTime localDateTimeA = LocalDateTime.parse(a);
//        LocalDateTime localDateTimeB = LocalDateTime.parse(b);
//        System.out.println(isSameQuarter( localDateTimeA,localDateTimeB ));
        System.out.println(isSameQuarter( parseToDate(a),parseToDate(b) ));
    }

}
