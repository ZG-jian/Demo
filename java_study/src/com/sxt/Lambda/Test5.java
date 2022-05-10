package com.sxt.Lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * lambda排序集合中的元素
 */
public class Test5 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("c");
        list.add("b");
        list.add("e");
        list.add("d");
        list.sort((o1,o2)->o1.compareTo(o2));

        list.forEach(System.out::println);
    }
}
