package com.jian.xml.dtd;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Jsoup解析本地、字符串、网页XML
 */
public class Demo2 {
    public static void main(String[] args) throws IOException {
        //解析本地XML
        String path = Demo2.class.getClassLoader().getResource("com/jian/xml/dtd/student.xml").getPath();

        Document document = Jsoup.parse(new File(path), "utf-8");
        System.out.println(document);
        System.out.println("---------------下面是解析字符串--------------------");

        //解析字符串
        Document document1 = Jsoup.parse("<?xml version=\"1.0\" ?>\n" +
                "<!DOCTYPE   students SYSTEM \"student.dtd\">\n" +
                "<students>\n" +
                "    <student number=\"jian001\">\n" +
                "        <name>张三</name>\n" +
                "        <age>18</age>\n" +
                "        <sex>18</sex>\n" +
                "    </student>\n" +
                "    <student number=\"jian002\">\n" +
                "        <name>王芳</name>\n" +
                "        <age>65</age>\n" +
                "        <sex>女</sex>\n" +
                "    </student>\n" +
                "</students>");
        System.out.println(document1);
        System.out.println("--------------------------------");
//解析网络资源
        Document document2 = Jsoup.parse(new URL("https://www.baidu.com"), 2000);
        System.out.println(document2);

    }
}
