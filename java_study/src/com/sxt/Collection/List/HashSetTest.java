package com.sxt.Collection.List;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    //也是大部分和list一模一样

    public static void main(String[] args) {
        //实例化HashSet
        Set<String> set = new HashSet<>();
        //添加元素
        set.add("a");
        set.add("b1");
        set.add("c1");
        set.add("d");

        for (String str:set
             ) {
            System.out.println(str);
        }
        //删除元素
        System.out.println("------删除元素，删除成功返回true--");
        System.out.println(set.remove("d"));
        System.out.println(set.remove("c1"));
        System.out.println("---------删除后的遍历----");
        for (String str:set
        ) {
            System.out.println(str);
        }
        System.out.println("-----删除后容器元素数量----");
        System.out.println(set.size());

        System.out.println("---------HashSet存储自定义对象-------------");
        Set<Users> set1 = new HashSet<>();

        Users u = new Users("张三",18);
        Users u1 = new Users("张三",18);
        set1.add(u);
        set1.add(u1);
//没重写equals和Hashcode就会一起存储

        System.out.println(u.hashCode());
        System.out.println(u1.hashCode());

        for (Users user:set1
             ) {
            System.out.println(user);
        }
        System.out.println("------------------------");


    }
}
