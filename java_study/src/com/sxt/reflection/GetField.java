package com.sxt.reflection;

import java.lang.reflect.Field;

public class GetField {
    public static void main(String[] args) throws Exception {
        Class aClass = Users.class;
        Field[] fields = aClass.getFields();
        System.out.println("---------public属性---------");
        for (Field f:fields
             ) {
            System.out.println(f);
            System.out.println(f.getName());
        }
        System.out.println("-----全----------");
        Field[] fields1 = aClass.getDeclaredFields();
        for (Field f:fields1
        ) {
            System.out.println(f);
            System.out.println(f.getName());
        }
        System.out.println("-----------下面就是通过属性名获取，也分public or 全中---------------");
        Field field = aClass.getField("age");
        System.out.println(field);
        System.out.println("-----");
        Field field1 = aClass.getDeclaredField("name");
        System.out.println(field1);

    }
}
