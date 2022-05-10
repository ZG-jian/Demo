package com.sxt.Collection.List;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ArraysListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        boolean flag = list.add("What the Fuck");
        boolean flag1 = list.add("Fuck you");
//插入元素，后面的后移
        list.add(1,"你看那");
        //修改并返回原来的元素
        System.out.println(list.set(1, "这也可以改"));

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println("--------------------");
        //根据所引位置删除元素
        System.out.println(list.remove(1));
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }
        System.out.println("**********");
        //删除指定元素
        boolean flag2 = list.remove("Fuck you");
        System.out.println(flag2);
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }
        System.out.println(list.remove("hahahahahahahahaah"));
        //给定元素在容器当中不存在时，remove方法返回false
        System.out.println("-----替换元素-----");
        String s1 = list.set(0, "你好吖");
        System.out.println(s1+"这是返回的被替换元素");
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }
        //清空容器

        list.clear();
        System.out.println("清空后的元素的个数"+list.size());
        System.out.println("是否为空"+list.isEmpty());
        list.add("你好吖");
        //如果容器中包含指定元素则返回true，否则返回false
        System.out.println("是否存在元素 "+list.contains("你好吖"));


        //类型转换
        System.out.println("-------类型转换------");
        list.add("abababbababababababb");
        list.add("cdcdcdcd");
        //第一种
        Object[] arr = list.toArray();
        for (int i = 0; i <arr.length; i++) {
            String str = (String)arr[i];
            System.out.println(str);
        }
        System.out.println("***第二种转换");
        //第二种
        String[] str2 = list.toArray(new String[list.size()]);
        for (int i = 0; i <str2.length; i++) {
            System.out.println(str2[i]);
        }
//并集
        List<String> list1 = new ArrayList();
        List<String> list2 = new ArrayList();

        list1.add("a");
        list1.add("b");
        list1.add("c");

        list2.add("e");
        list2.add("f");
        list2.add("g");

        boolean b = list1.addAll(list2);
        System.out.println("------并集");
        for (String str:list1) {
            System.out.print(str);
        }
        //交集
        List<String> list3 = new ArrayList();
        List<String> list4 = new ArrayList();
        list3.add("a");
        list3.add("b");
        list3.add("c");

        list4.add("b");
        list4.add("c");
        list4.add("g");
        list3.retainAll(list4);
        System.out.println();
        System.out.println("------交集");
        for (String str:list3) {
            System.out.print(str);
        }
        //差集
        System.out.println("\n 差集");
        List<String> list5 = new ArrayList();
        List<String> list6 = new ArrayList();

        list5.add("a");
        list5.add("c");
        list5.add("e");

        list6.add("b");
        list6.add("c");
        list6.add("e");
        list5.removeAll(list6);
        for (String str:list5) {
            System.out.print(str);
        }
        List<String> v = new Vector<>();
        v.add("这里是Vector噢");
        v.add("Let me see ?");
        System.out.println("------------Vector---");
        for (String str: v) {
            System.out.println(str);
        }
    }
}
