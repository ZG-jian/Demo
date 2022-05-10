package com.jianjian.frank_api.calendar;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestCalendar {
    public static void main(String[] args) {
        //得到日期
        GregorianCalendar calendar = new GregorianCalendar(2050,6,5,12,30,59);
        System.out.println(calendar.get(Calendar.YEAR));
        //设置日期
        GregorianCalendar calendar2 = new GregorianCalendar();
        calendar2.set(Calendar.YEAR,2028);
        System.out.println(calendar2.get(Calendar.YEAR));

        GregorianCalendar calendar3 = new GregorianCalendar(2077,6,22,4,25);
//日期的计算
        //        calendar3.add(Calendar.YEAR,-7);
//        calendar3.add(Calendar.MONTH,2);
        System.out.println(calendar3.toString());
//日历对象和时间对象转化
        Date date = calendar3.getTime();
        GregorianCalendar calendar4 = new GregorianCalendar();
        calendar4.setTime(new Date());

        System.out.println(date);
        System.out.println(calendar4.get(Calendar.YEAR));


        printCalendar(calendar3);
    }
    static void printCalendar(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int date = calendar.get(Calendar.DAY_OF_WEEK) - 1; // 星期几
        String week = "" + ((date == 0) ? "日" : date);
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        System.out.printf("%d 年%d 月%d 日,星期%s %d:%d:%d\n", year, month, day, week, hour, minute, second);
    }
}
