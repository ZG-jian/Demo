package com.sxt.Collection.List;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        //排序，String类元素本身实现了比较规则
        System.out.println("String类的元素自身实现排序规则");
        Set<String> set = new TreeSet<>();
        set.add("d");
        set.add("c");
        set.add("a");
        set.add("b");
        for (String str:set
             ) {
            System.out.println(str);
        }
        System.out.println("--------------通过元素自身来实现比较规则------------------");
        Set<Users> set1 = new TreeSet<>();
        //通过元素自身来实现比较规则
        Users u = new Users("简简",18);
        Users u1 = new Users("admin",26);
        Users u2 = new Users("frank",26);
        set1.add(u);
        set1.add(u1);
        set1.add(u2);

        for (Users user:set1
             ) {
            System.out.println(user);
        }
        System.out.println("--------通过比较器来实现比较规则---------");
        Set<Student> set2 = new TreeSet<>(new StudentComparator());
        Student s1 = new Student("jianjian",18);
        Student s2 = new Student("admin",26);
        Student s3 = new Student("frank",26);
        set2.add(s1);
        set2.add(s2);
        set2.add(s3);
        for (Student student:set2
             ) {
            System.out.println(student);

        }
    }
}
