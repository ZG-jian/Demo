package com.sxt.Collection.List;

import java.util.*;

//迭代器的使用(一个迭代器只能用一次)
public class IteratorListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
//获取迭代对象
        //方式一，通过while循环获取元素
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("------------------------------------");
//方式二，通过for循环获取元素
        for (Iterator<String> iterator1 = list.iterator();iterator1.hasNext();){
            System.out.println(iterator1.next());
        }

        Set<String> set = new HashSet<>();
        set.add("A");
        set.add("b");
        set.add("c");
        set.add("d");
        System.out.println("-------------------------");
        //while循环
        Iterator<String> iterator1 = set.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
        System.out.println("-----------------");
        //for--
        for (Iterator<String> it = set.iterator();it.hasNext();){
            System.out.println(it.next());
        }
    }
}
