package com.jianjian.frank_api.calendar;

import java.util.Calendar;

public class Test1 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        int year = calendar.get(Calendar.YEAR);
        System.out.println(year);
        int month = calendar.get(Calendar.MONTH) + 1;
        System.out.println(month);//西方国家月份从零开始
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        System.out.println(dayOfWeek);//西方国家星期从星期天开始
        //紫色的那些叫字段，api里面有很多******


    }
}
