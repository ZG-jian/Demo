package com.sxt.Collection.List;

import com.sxt.Collection.List.Student;

import java.util.*;


public class TreeMapTest {
    public static void main(String[] args) {
        //这两个比较跟TreeSet几乎一样

        //TreeMap元素自身实现比较规则
        Map<Users,String> treeMap = new TreeMap<>();
        Users u1 = new Users("jianjian",18);
        Users u2 = new Users("admin",22);
        Users u3 = new Users("frank",22);
        treeMap.put(u1,"jianjian");
        treeMap.put(u2,"admin");
        treeMap.put(u3,"frank");
        Set<Users> keySet2 = treeMap.keySet();
        for (Users key:keySet2
        ) {
            System.out.println(key+"----------"+treeMap.get(key));
        }
        System.out.println("------------------------------------");
//通过比较器实现比较规则
        Map<Student,String> treeMap2 = new TreeMap<>(new StudentComparator());
        Student s1 = new Student("jianjian",18);
        Student s2 = new Student("admin",22);
        Student s3 = new Student("frank",22);
        treeMap2.put(s1,"jianjian");
        treeMap2.put(s2,"admin");
        treeMap2.put(s3,"frank");
        Set<Student> keySet3 = treeMap2.keySet();
        for (Student key:keySet3
        ) {
            System.out.println(key+"----------"+treeMap2.get(key));
        }
    }
}
