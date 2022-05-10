package com.sxt.Collection.List;

import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();

        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        System.out.println(list.get(0));
        for (String str:list) {
            System.out.println(str);
        }
        System.out.println("------------------");
        list.set(1,"zzz");
        for (String str:list) {
            System.out.println(str);
        }

        System.out.println("---------非List标准--------------");
        LinkedList<String> linkedList =  new LinkedList<>();
        linkedList.add("add添加");
        linkedList.addFirst("addFist添加");
        linkedList.addLast("addLast添加");

        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println("-------------");
        for (String str:linkedList
             ) {
            System.out.println(str);
        }
        System.out.println("----------------");
        //移除列表第一，最后一个元素并返回
       linkedList.removeFirst();
       linkedList.removeLast();
        for (String str:linkedList
        ) {
            System.out.println(str);
        }
        //等效于removeFirst
        System.out.println(linkedList.pop());

        System.out.println(linkedList.isEmpty());
    }
}
