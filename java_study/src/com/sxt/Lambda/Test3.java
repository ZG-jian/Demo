package com.sxt.Lambda;

import java.util.ArrayList;
import java.util.List;
//通过lambda遍历集合

/**
 * 一般需要创建一个Consumer接口的实现类，然后实现里面的run方法
 * 并在main里创建实现类对象把它放到forEach里，这样forEach遍历就会
 * 把遍历到的元素按照实现的run方法执行
 *
 * 但使用另一种如下方式就会简便很多
 */
public class Test3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.forEach(System.out::println);
    }
}
