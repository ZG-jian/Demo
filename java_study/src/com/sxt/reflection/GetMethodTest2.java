package com.sxt.reflection;

import java.lang.reflect.Method;

/**
 * 通过反射调用方法
 */
public class GetMethodTest2 {
    public static void main(String[] args) throws Exception {
        Class aClass = Users.class;
        Method method1 = aClass.getDeclaredMethod("setAge", int.class);
        //实例化对象
        Users users = new Users();
        //通过反射的方法赋值
        method1.invoke(users,18);
        System.out.println(users);
        Method method2 = aClass.getDeclaredMethod("setName", String.class);
        method2.invoke(users,"简");
        Method method3 = aClass.getDeclaredMethod("setSex", String.class);
        method3.invoke(users,"男");
        System.out.println(users);
        //调用私有方法
        Method method4 = aClass.getDeclaredMethod("FuckPPT");
        method4.setAccessible(true);//设置可以访问，不然访问不了私有，为true时可以访问私有类型变量

        method4.invoke(users);//报了个非法访问，跟之前一样

    }
}
