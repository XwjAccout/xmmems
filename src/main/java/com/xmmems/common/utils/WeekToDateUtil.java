package com.xmmems.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WeekToDateUtil {
    //获取这一年的日历
    private static Calendar getCalendarFormYear(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.YEAR, year);
        return cal;
    }

    //获取某一年的某一周的周日日期 ，如果是最后一周，周日可能是明年的日期
    private static String getSundayOfWeekNo(int year, int weekNo) {
        Calendar cal = getCalendarFormYear(year);
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);
        cal.add(Calendar.DAY_OF_WEEK, 6);
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }

    //获取某一年的某一周的周一日期 ，如果是第一周，周一可能是去年的日期
    private static String getMondayOfWeekNo(int year, int weekNo) {
        Calendar cal = getCalendarFormYear(year);
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }

    //获取某一年的某一周的开始日期, 如果是第一周，则开始时间是1月1日
    public static String getStartDay(int year, int weekNo) {
        return getMondayOfWeekNo(year, weekNo);
    }

    //获取某一年的某一周的结束日期 ,如果是最后一周，则结束日期是12月31号
    public static String getEndDay(int year, int weekNo) {
        return getSundayOfWeekNo(year, weekNo);
    }

    public static void main(String[] args) {
        System.out.println(getStartDay(2020, 53));
        System.out.println(getEndDay(2020, 53));
    }

}
