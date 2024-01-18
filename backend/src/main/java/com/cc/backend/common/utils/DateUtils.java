package com.cc.backend.common.utils;

import cn.hutool.core.date.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


public class DateUtils {

    private static String[] parsePatterns = {"yyyy-MM-dd", "yyyy年MM月dd日",
            "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy/MM/dd",
            "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyyMMdd", "yyyy.MM.dd HH:mm", "yyyy.MM.dd"};

    /**
     * 将字符串转换为时间
     * @param string
     * @return
     */
    public static Date parseDate(String string) {
        if (string == null) {
            return null;
        }

        return DateUtil.parse(string, parsePatterns);

    }

    /**
     * 获取当月第一天
     * @return
     */
    public static String getFirstDay() {
        HashMap<String, Object> data = new HashMap<>();

        // 获取当月第一天
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String firstday;
        // 获取前月的第一天
        Calendar cale = Calendar.getInstance();

        cale.add(Calendar.MONTH, 0);

        cale.set(Calendar.DAY_OF_MONTH, 1);

        firstday = format.format(cale.getTime());

        return firstday;
    }

    /**
     * 获取当月最后一天
     * @return
     */
    public static String getLastDay() {
        HashMap<String, Object> data = new HashMap<>();

        // 获取当月最后一天
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        String lastday;

        Calendar cale = Calendar.getInstance();

        // 获取前月的最后一天
        cale.add(Calendar.MONTH, 1);

        cale.set(Calendar.DAY_OF_MONTH, 1);

        lastday = format.format(cale.getTime());

        return lastday;
    }


    /**
     * 日期比较
     * @param source
     * @param target
     * @return
     */
    public static Integer compareTo(Date source, Date target) {
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
     * 日期相减
     * @param source
     * @param target
     * @return
     */
    public static int subtract(Date source, Date target) {
        long days = ChronoUnit.DAYS.between(
                source.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                target.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        );
        return (int) days;
    }

    /**
     * 获取给定时间之前第n天的日期
     *
     * @param source
     * @param beforeDays
     * @return
     */
    public static Date getDateBefore(Date source, Integer beforeDays) {
        Calendar calendar = Calendar.getInstance(); // 获取当前日期和时间
        calendar.setTime(source); // 设置给定时间
        calendar.add(Calendar.DAY_OF_MONTH, -beforeDays); // 获取给定时间之前第n天的日期
        Date target = calendar.getTime();
        return target;
    }

    /**
     * 获取给定时间之后第n天的日期
     *
     * @param source
     * @param afterDays
     * @return
     */
    public static Date getDateAfter(Date source, Integer afterDays) {
        Calendar calendar = Calendar.getInstance(); // 获取当前日期和时间
        calendar.setTime(source); // 设置给定时间
        calendar.add(Calendar.DAY_OF_MONTH, afterDays); // 获取给定时间之前第n天的日期
        Date target = calendar.getTime();
        return target;
    }


    /**
     * 获取当前时间属于第几季度
     *
     * @param date
     * @return
     */
    public static int getQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);

        if (month >= Calendar.JANUARY && month <= Calendar.MARCH) {
            return 1;
        } else if (month >= Calendar.APRIL && month <= Calendar.JUNE) {
            return 2;
        } else if (month >= Calendar.JULY && month <= Calendar.SEPTEMBER) {
            return 3;
        } else {
            return 4;
        }
    }


    /**
     * 获取当前时间属于第几季度
     *
     * @param date
     * @return
     */
    public static String getQuarterChinese(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);

        if (month >= Calendar.JANUARY && month <= Calendar.MARCH) {
            return "第一季度";
        } else if (month >= Calendar.APRIL && month <= Calendar.JUNE) {
            return "第二季度";
        } else if (month >= Calendar.JULY && month <= Calendar.SEPTEMBER) {
            return "第三季度";
        } else {
            return "第四季度";
        }
    }

    /**
     * 获取当前月份
     *
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
        // 创建一个Calendar对象，并将其时间设置为当前时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // 获取输入时间的月份
        int month = calendar.get(Calendar.MONTH) + 1; // 注意要加1，因为月份是从0开始计数的
        return month;
    }

    /**
     * 获取当前年份
     *
     * @param date
     * @return
     */
    public static int getYear(Date date) {
        // 创建一个Calendar对象，并将其时间设置为当前时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // 获取输入时间的年份
        int year = calendar.get(Calendar.YEAR);
        return year;
    }

    /**
     * 获取当前月份（中文）
     *
     * @param date
     * @return
     */
    public static String getChineseMouth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int month = calendar.get(Calendar.MONTH);

        String[] chineseMonths = {"一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"};

        return chineseMonths[month];
    }


    /**
     * 获取给定年份和月份的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getLastDayOfMonth(int year,int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1); // 将日期设置为指定年份和月份的第一天
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH)); // 获取该月份的最后一天
        Date lastDayOfMonth = calendar.getTime();
        return lastDayOfMonth;
    }

    /**
     * 获取给定年份和月份的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getFirstDayOfMonth (int year,int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1); // 将日期设置为指定年份和月份的第一天
        Date firstDayOfMonth = calendar.getTime();
        return firstDayOfMonth;
    }


    /**
     * 获取给定年份和季度的最后一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getLastDayOfQuarter(int year,int quarter ) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, (quarter - 1) * 3 + 2); // 设置为季度的最后一个月
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH)); // 获取该月份的最后一天
        Date lastDayOfQuarter = calendar.getTime();
        return lastDayOfQuarter;
    }

    /**
     * 获取给定年份和季度的第一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getFirstDayOfQuarter (int year,int quarter) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, (quarter - 1) * 3); // 设置为季度的第一个月
        calendar.set(Calendar.DAY_OF_MONTH, 1); // 设置为月份的第一天
        Date firstDayOfQuarter = calendar.getTime();
        return firstDayOfQuarter;
    }

    /**
     * 获取给定年份的第一天
     *
     * @param year
     * @return
     */
    public static Date getFirstDayOfYear(int year ) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, 0); // 设置为1月份
        calendar.set(Calendar.DAY_OF_MONTH, 1); // 设置为月份的第一天

        Date firstDayOfYear = calendar.getTime();
        return firstDayOfYear;
    }

    /**
     * 获取给定年份的最后一天
     *
     * @param year
     * @return
     */
    public static Date getLastDayOfYear(int year ) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, 11); // 设置为12月份
        calendar.set(Calendar.DAY_OF_MONTH, 31); // 设置为月份的最后一天

        Date lastDayOfYear = calendar.getTime();
        return lastDayOfYear;
    }


    /**
     * 判断两个时间之间 月份否相差1个月
     * @param source
     * @param target
     * @return
     */
    public static boolean getMonthsBetween1(Date source,Date target ){
        // 定义两个时间
        LocalDate date1 = LocalDate.of(DateUtil.year(source), DateUtil.month(source), 1);
        LocalDate date2 = LocalDate.of(DateUtil.year(target), DateUtil.month(target), 1);

        // 判断两个时间之间相差一个月
        long monthsBetween = ChronoUnit.MONTHS.between(date1, date2);
        boolean isOneMonthDifference = Math.abs(monthsBetween) == 1;
        boolean flag=false;
        // 输出结果
        if (isOneMonthDifference) {
            System.out.println("两个时间之间相差一个月");
            flag=true;

        } else {
            flag=false;
            System.out.println("两个时间之间不相差一个月");
        }
        return flag;
    }


    public static boolean isSameMonth(Date source,Date target ){
        // 定义两个时间
        LocalDate date1 = LocalDate.of(DateUtil.year(source), DateUtil.month(source), 1);
        LocalDate date2 = LocalDate.of(DateUtil.year(target), DateUtil.month(target), 1);

        // 判断两个时间之间相差一个月
        long monthsBetween = ChronoUnit.MONTHS.between(date1, date2);
        boolean iSameMonth = Math.abs(monthsBetween) == 0;
        boolean flag=false;
        // 输出结果
        if (iSameMonth) {
            flag=true;
        } else {
            flag=false;
        }
        return flag;
    }


    /**
     * 判断两个时间之间 季度否相差1个季度
     * @param source
     * @param target
     * @return
     */
    public static boolean getQuarterBetween1(Date source,Date target ){
        // 定义两个时间
        LocalDate date1 = LocalDate.of(DateUtil.year(source), DateUtil.month(source), 1);
        LocalDate date2 = LocalDate.of(DateUtil.year(target), DateUtil.month(target), 1);

        // 判断两个时间之间相差一个季度
        long monthsBetween = ChronoUnit.MONTHS.between(date1, date2);
        boolean isOneQuarterDifference = Math.abs(monthsBetween) == 3;
        boolean flag=false;
        // 输出结果
        if (isOneQuarterDifference) {
            System.out.println("两个时间之间相差一个季度");
            flag =true;
        } else {
            System.out.println("两个时间之间不相差一个季度");
            flag=false;
        }
        return flag;
    }

    public static boolean isSameQuarter(Date source,Date target ) {
        LocalDate date1 = LocalDate.of(DateUtil.year(source), DateUtil.month(source), 1);
        LocalDate date2 = LocalDate.of(DateUtil.year(target), DateUtil.month(target), 1);
        int quarter1 = (date1.getMonthValue() - 1) / 3 + 1;
        int quarter2 = (date2.getMonthValue() - 1) / 3 + 1;
        int year1 = date1.getYear();
        int year2 = date2.getYear();

        return quarter1 == quarter2 && year1 == year2;
    }


    /**
     * 判断两个时间之间 季度否相差1年
     * @param source
     * @param target
     * @return
     */
    public static boolean getYearBetween1(Date source,Date target ){
        // 创建 Calendar 对象
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();

        // 设置两个时间
        calendar1.setTime(source);
        calendar2.setTime(target);

        // 计算两个时间之间的年差
        int yearDiff = calendar2.get(Calendar.YEAR) - calendar1.get(Calendar.YEAR);

        boolean flag;
        // 判断两个时间之间是否只相差一个季度
        if (yearDiff == 1) {
            System.out.println("两个时间之间只相差一年");
            flag =true;
        } else {
            System.out.println("两个时间之间不只相差一年");
            flag =false;
        }
        return flag;
    }


    /**
     * 获取下一个月的第一天
     * @param source
     * @return
     */
    public static Date getNextMonthFirstDay(Date source){
        // 创建 Calendar 对象
        Calendar calendar = Calendar.getInstance();

        // 设置时间
        calendar.setTime(source);

        // 获取下个月 1 号
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        // 获取日期
        Date nextMonthFirstDay = calendar.getTime();
        return nextMonthFirstDay;
    }


    /*
     * 获取某一天的开始时间
     *
     * */
    public static Date getBeginOfDay(Date source){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            // 创建Calendar对象并设置为给定时间
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(source);

            // 设置时间为当天的最后时间
            calendar.set(Calendar.HOUR_OF_DAY, 00);
            calendar.set(Calendar.MINUTE, 00);
//            calendar.set(Calendar.SECOND, 00);
//            calendar.set(Calendar.MILLISECOND, 000);

            // 获取当天最后时间
            Date firstTimeOfDay = calendar.getTime();

            System.out.println("当天开始时间：" + sdf.format(firstTimeOfDay));
            return firstTimeOfDay;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * 获取某一天的结束时间
     *
     * */
    public static Date getEndOfDay(Date source){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            // 创建Calendar对象并设置为给定时间
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(source);

            // 设置时间为当天的最后时间
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
//            calendar.set(Calendar.SECOND, 59);
//            calendar.set(Calendar.MILLISECOND, 999);

            // 获取当天最后时间
            Date lastTimeOfDay = calendar.getTime();

            System.out.println("当天最后时间：" + sdf.format(lastTimeOfDay));
            return lastTimeOfDay;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 获取下个季度的第一天
     * @param source
     * @return
     */
    public static Date addNextQuarter(Date source){
        int year = getYear(source);
        int month = getMonth(source);
        int quarter = getQuarter(source);
        Date nextQuarter=null;
        switch (quarter){
            case 1:
                Calendar calendar = Calendar.getInstance();
                calendar.set(year,3,1);
                nextQuarter = getBeginOfDay(calendar.getTime());
                break;
            case 2:
                Calendar calendar2 = Calendar.getInstance();
                calendar2.set(year,6,1);
                nextQuarter = getBeginOfDay(calendar2.getTime());
                break;
            case 3:
                Calendar calendar3 = Calendar.getInstance();
                calendar3.set(year,9,1);
                nextQuarter = getBeginOfDay(calendar3.getTime());
                break;
            case 4:
                Calendar calendar4 = Calendar.getInstance();
                calendar4.set(year+1,0,1);
                nextQuarter = getBeginOfDay(calendar4.getTime());
                break;
        }
        return nextQuarter;
    }
}
