package com.wll.project.utils;


/**
 * @Auther HUGH
 * @Date 2018/5/6
 * @Description DateUtils
 */
public class DateUtils {
    private static  int year;
    private static int month;

    public static int getMainYear(){
      return year;
    }
    public static int getMonth(){
        return month;
    }

    public static void setYear(int year) {
        DateUtils.year = year;
    }

    public static void setMonth(int month) {
        DateUtils.month = month;
    }
}
