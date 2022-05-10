package com.sxt.reflection;

import java.io.Serializable;
import java.lang.annotation.Annotation;

/**
 * 获取类的其他信息
 */
public class GetClassInfo implements Serializable {
    public static void main(String[] args) {
        //skdfhkasjajkdhas
        Class aClass = Users.class;
        //获取类名
        System.out.println(aClass.getName());
        //获取包名
        System.out.println(aClass.getPackage());
        //获取超类
        System.out.println(aClass.getSuperclass());
        //获取该类实现的所有接口
        Class[] arr = aClass.getInterfaces();
        for (Class a:arr
             ) {
            System.out.println(a.getName());
        }
        //api还有很多方法暂时还未测试
        System.out.println("--------借用地方测试注释----------");
        Annotation[] declaredAnnotations = aClass.getDeclaredAnnotations();
        for (Annotation a:declaredAnnotations
             ) {
            System.out.println(a.toString());

        }
    }
}
