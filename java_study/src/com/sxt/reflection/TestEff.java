package com.sxt.reflection;

import java.lang.reflect.Method;

public class TestEff {
    public static void main(String[] args) throws Exception {
        Class aClass = Users.class;

        //反射耗时
        Users users = (Users) aClass.newInstance();
        Method method = aClass.getDeclaredMethod("setName", String.class);
        long reflectStart = System.currentTimeMillis();
        method.setAccessible(true);
        for (int i = 0; i < 100000000; i++) {
            method.invoke(users,"简");
        }
        long reflectEnd = System.currentTimeMillis();

        //非反射耗时
        Users users1 = new Users();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            users1.setName("简");
        }
        long end = System.currentTimeMillis();
        System.out.println("反射测试耗时："+(reflectEnd-reflectStart));
        System.out.println("普通执行方式耗时："+(end-start));
    }
}
