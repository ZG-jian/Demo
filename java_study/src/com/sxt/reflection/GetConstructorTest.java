package com.sxt.reflection;

import java.lang.reflect.Constructor;

public class GetConstructorTest {
    public static void main(String[] args) throws NoSuchMethodException {
        Class aClass = Users.class;
        System.out.println("获取全部构造方法");
        Constructor[] constructors = aClass.getDeclaredConstructors();
        for (Constructor c:constructors) {
            System.out.println(c);
        }
        System.out.println("----------获取public构造----------------");
        Constructor[] constructors1 = aClass.getConstructors();
        for (Constructor c:constructors1) {
            System.out.println(c);
        }
        System.out.println("------------获取一个，全部中的一个-----------");
        Constructor constructors2 = aClass.getDeclaredConstructor(int.class);
        System.out.println(constructors2);
        System.out.println("---------------获取public中的一个-------------");
        Constructor constructor3 = aClass.getConstructor(null);
        System.out.println(constructor3);

    }
}
