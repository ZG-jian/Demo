package com.jian.xml.Jsoup;

import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.util.List;

/**
 * Xpath语法在w3school里可以找，有需要再弄
 */
public class XpathDemo {
    public static void main(String[] args) throws Exception {
        //2. 获取 Document 对象
        String path = XpathDemo.class.getClassLoader().getResource("com/jian/xml/Jsoup/student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        // 3. 将 Document 对象转为 JXDocument 对象
        JXDocument jxDocument = new JXDocument(document);
        // 4. JXDocument 调用 selN(String xpath)，获取 List<JXNode>对象。
        List<JXNode> jxNodes = jxDocument.selN("//name");
        // 5. 遍历 List<JXNode>，调用 JXNode 的 getElement()，转为 Element 对象。
        for (JXNode jxNode : jxNodes) {
            // 6. 处理 Element 对象。
            Element element = jxNode.getElement();
            System.out.println(element.text());
        }
        System.out.println("-----------------");
        //根据属性寻找结点
        List<JXNode> jxNodes1 = jxDocument.selN("//student[@number='jian002']");
        for (JXNode jxNode : jxNodes1) {
            // 6. 处理 Element 对象。
            Element element = jxNode.getElement();
            System.out.println(element);
        }
        System.out.println("---------------------");
        //获取结点下的子结点
        List<JXNode> jxNodes2 = jxDocument.selN("//student[@number='jian002']/age");
        for (JXNode jxNode : jxNodes2) {
            // 6. 处理 Element 对象。
            Element element = jxNode.getElement();
            System.out.println(element);
        }
    }
}
