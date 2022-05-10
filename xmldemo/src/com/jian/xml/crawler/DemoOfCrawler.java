package com.jian.xml.crawler;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * 爬虫
 */
public class DemoOfCrawler {
    public static void main(String[] args) {
        int min = 0;
        int max = 0;

        // 1. 写爬虫程序的 XML 配置文件
        // 2. 解析 XML 配置文件：加载 XML 文件到内存，转为 Document 对象。

        try {
            String path = DemoOfCrawler.class.getClassLoader().getResource("com/jian/xml/crawler/Crawler.xml").getPath();
            Document document1 = Jsoup.parse(new File(path), "utf-8");
            //使用Xpath解析xml获取信息，当作复习
            JXDocument jxDocument = new JXDocument(document1);
            // 3. 获取 XML 配置文件的配置信息
            List<JXNode> minNodes = jxDocument.selN("//min");
            List<JXNode> maxNodes = jxDocument.selN("//max");

            Element minElement = minNodes.get(0).getElement();
            Element maxElement = maxNodes.get(0).getElement();

            String minText = minElement.text();
            String maxText = maxElement.text();

            // 4. 将配置信息应用于爬虫程序中
            min = Integer.parseInt(minText);
            max = Integer.parseInt(maxText);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XpathSyntaxErrorException e) {
            e.printStackTrace();
        }


        //  5. 设置循环自动爬取
        for (int i = min; i < max; i++) {
            try {
                // 1. 引入 jar 包。
                //  2. 使用 Jsoup 获取网页 HTML 源文件，转为 Document 对象
                Document document = Jsoup.parse(new URL("http://daily.zhihu.com/story/" + i), 500);
                //  3. 通过 Document 对象，获取需要的 Element 对象
                //根据类获取
                Elements ImgEle = document.select(".avatar");
                Elements titleEle = document.select(".question-title");
                Elements authorEle = document.select(".author");
                Elements contentEle = document.select(".content");

                //  4. 获取 Element 对象的数据。
                String Imgsrc = ImgEle.get(0).attr("src");
                String header = titleEle.text();
                String author = authorEle.text();
                String content = contentEle.text();
                System.out.println(Imgsrc);
                System.out.println(header);
                System.out.println(author);
                System.out.println(content);
                //下面是自己加的实现换行功能
                /*for (int j = 0; j <content.length() ; j++) {
                    if (j%70==1){
                        System.out.println(content.substring(j,j+70));
                        System.out.p rintln();
                    }

                }*/
                System.out.println("--------------------------------------------");

            } catch (Exception e) {

            }

        }
    }
}
