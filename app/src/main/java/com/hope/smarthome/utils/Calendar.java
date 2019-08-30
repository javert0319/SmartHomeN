package com.hope.smarthome.utils;

import com.blankj.utilcode.util.LogUtils;

/**
 * @ClassName: Calendar
 * @Description: 作用描述
 * @Author: CHIA
 * @CreateDate: 2019/8/20 14:10
 */
public class Calendar {

    private static final String[] weekOfDay = new String[]{"","星期一","星期二","星期三","星期四","星期五","星期六","星期日"};
    /**
     * 判断是否为闰年
     * @param year
     * @return
     */
    public boolean isLeapYear(int year){
        return ((year % 4 == 0)&& (year % 100 != 0))||(year % 400 == 0);
    }

    /**
     * 儒略日计算星期几
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     * @param second
     * @return
     */
    public String weekOfDay(int year,int month,int day,int hour,int minute,Double second){
        Double aDouble = calculateJulianDay(year, month, day, hour, minute, second);
        int week = (int)(aDouble % 7 + 1);
        LogUtils.i("jiawei","Calendar weekOfDay " + week);
        return weekOfDay[week];
    }
    /**
     * 儒略日计算
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     * @param second
     * @return
     */
    public Double calculateJulianDay(int year,int month,int day,int hour,int minute,Double second){
        int a = (14 - month ) / 12;
        int y = year + 4800 - a;
        int m = month + 12*a - 3;
        double jdn = day + (153*m + 2) / 5 + 365 * y + y / 4;
        if(isGregorianCalendar(year,month,day)){
            jdn = jdn - y / 100 + y / 400 - 32045.5;
        }else {
            jdn -= 32083.5;
        }
        return jdn + hour/24.0 + minute/1440.0 + second/86400.0;
    }

    /**
     * 判断是否为格里历（公历）
     * @param year
     * @param month
     * @param day
     * @return
     */
    private boolean isGregorianCalendar(int year, int month, int day) {
        return year > 1582 || (year == 1582 && month > 10) || (year == 1582 && month == 10 && day >= 15);
    }

    /**
     * c:世纪数-1的值，如21世纪，则c=20
     * m：月数，m的取值是大于等于3，小于等于14，在蔡勒公式中末年的1，2月看作上一年的13，14月
     * y：年份，取公元纪年的后两位
     * d：某月内的日数
     * 蔡勒公式计算星期几
     * @param year
     * @param month
     * @param day
     * @return
     */
    public String zellerWeek(int year,int month,int day){
        int m = month;
        int d = day;
        if (month<=2){//对小于2的月份就行修正
            year--;
            m = month + 12;
        }
        int y = year % 100;
        int c = year / 100;
        int w = (y + y/4 + c/4 - 2*c +(13*(m+1)/5)+d - 1)%7;
        if (w<0){//修正计算结果为负数的情况
            w +=7;
        }
        return weekOfDay[w];
    }
}
