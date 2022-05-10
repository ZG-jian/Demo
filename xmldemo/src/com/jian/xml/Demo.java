package com.jian.xml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Jsoup快速入门案例
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        //(2) 加载 XML 文档进内存，获取 DOM 树对象 Document
        // 2.1 找到 XML 文档的绝对路径
        // 利用类加载器，通过项目中文件的相对路径找到硬盘中的绝对路径
        ClassLoader classLoader = Demo.class.getClassLoader();
        String path = classLoader.getResource("com/jian/xml/dtd/student.xml").getPath();
//        System.out.println(path);
        // 2.2 根据 XML 文档的路径，把 XML 文档加载进内存，并解析成 Dom 树对象
        Document document = Jsoup.parse(new File(path), "utf-8");
        //(3) 获取对应的标签 Element 对象
        Elements name = document.getElementsByTag("name");
        //(4) 获取数据
        for (Element element:name
             ) {
            System.out.println(element.text());

        }
    }
}
