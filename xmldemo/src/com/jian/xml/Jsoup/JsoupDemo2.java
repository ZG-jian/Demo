package com.jian.xml.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;

public class JsoupDemo2 {
    public static void main(String[] args) throws IOException {
        String path = com.jian.xml.dtd.Demo2.class.getClassLoader().getResource("com/jian/xml/Jsoup/student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        Elements elements = document.getElementsByAttributeValue("number", "jian001");
            for (Element element : elements) {
            System.out.println(elements.text());
            System.out.println(element.html());
            System.out.println(element.attr("number"));
        }

    }
}
