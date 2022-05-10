package com.jian.xml.Jsoup;

import com.jian.xml.dtd.Demo2;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo {
    public static void main(String[] args) throws IOException {
        //解析本地XML
        String path = Demo2.class.getClassLoader().getResource("com/jian/xml/Jsoup/student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        //根据id获取元素
        Element element = document.getElementById("a1");
        System.out.println(element.text());
        System.out.println("-----------------------");

        //根据标签获取元素
        Elements elements = document.getElementsByTag("age");
        for (Element element1 : elements) {
            System.out.println(element1.text());
        }
        System.out.println("--------------------------");
        //根据属性获取元素
        Elements elements1 = document.getElementsByAttribute("number");
        for (Element element1 : elements1) {
            System.out.println(element1.text());
        }
        System.out.println("--------根据属性获取全部-------------");
        for (Element element1 : elements1) {
            System.out.println(element1);
        }
        System.out.println("------------根据属性名=属性值获取元素---------------");
        //根据属性名=属性值获取元素
        Elements elements2 = document.getElementsByAttributeValue("number", "jian001");
        for (Element element1 : elements2) {
            System.out.println(element1);
        }
        //使用选择器获取元素
        System.out.println("-----------根据选择器----------");
        Elements select = document.select("#a1");
        System.out.println(select);
        System.out.println("---------------");

        Elements select1 = document.select(".nn");
        System.out.println(select1);
        System.out.println("--------选择器选择标签-------------");

        //选择器选择元素----跟根据标签获取一样
        Elements name = document.select("name");
        for (Element element1 : name) {
            System.out.println(element1);
        }
    }
}
