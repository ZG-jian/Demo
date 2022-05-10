package com.sxt.Collection.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("b");
        list.add("d");
        list.add("a");
        list.add("c");
        //通过 Collections 工具类中的 sort 方法完成排序
        Collections.sort(list);
        for (String str:list
             ) {
            System.out.println(str);
        }
        System.out.println("--------------------------------");
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        //乱序处理
        Collections.shuffle(list1);
        for (String str:list1
             ) {
            System.out.println(str);

        }
    }
}
