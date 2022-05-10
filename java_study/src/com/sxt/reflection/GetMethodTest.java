package com.sxt.reflection;

import java.lang.reflect.Method;

/**
 * 获取方法
 */
public class GetMethodTest {
    public static void main(String[] args) throws Exception {
        Class aClass = Users.class;
        Method[] methods = aClass.getDeclaredMethods();
        System.out.println("------------输出全部方法---------------");
        for (Method s:methods
             ) {
            System.out.println(s);
            System.out.println(s.getName());
        }
        System.out.println("--------------输出公共方法----");
        Method[] methods1 = aClass.getMethods();
        for (Method s:methods1
        ) {
            System.out.println(s.getName());
        }
        System.out.println("--------输出一个of全部，这里就来个私有的了----------");
        Method method1 = aClass.getDeclaredMethod("FuckPPT");
        System.out.println(method1.getName());
        System.out.println("---------------输出一个公共----------------");
        Method method = aClass.getDeclaredMethod("setAge", int.class);
        System.out.println(method.getName());
    }
}
