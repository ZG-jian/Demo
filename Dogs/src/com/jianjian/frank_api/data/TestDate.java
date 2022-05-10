package com.jianjian.frank_api.data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
    public static void main(String[] args) throws ParseException {


//        按照定义格式打印当前时间
        Date date = new Date();
        System.out.println("按照定义格式打印当前时间");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(date));

        //date对象转化为字符串
        System.out.println("date对象用定义格式转化为字符串");
        String str = simpleDateFormat.format(date);
        System.out.println(str);

        DateFormat df = new SimpleDateFormat("今年第w周,今年第D天");
        System.out.println(df.format(date));
        //String类型按照我们的格式转化为date类型
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime =  "2021-03-27 19:47:58";
        Date date2 = simpleDateFormat.parse(nowTime);
        System.out.println(date2);



    }
}
