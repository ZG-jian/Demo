package com.sxt.reflection;

import java.lang.reflect.Constructor;
//通过构造方法创建对象
public class GetConstructorNew {
    public static void main(String[] args) throws Exception {
        Class aClass = Users.class;
        Constructor constructor = aClass.getConstructor(String.class,int.class);
        Object o = constructor.newInstance("简", 18);
        Users users = (Users)o;
        System.out.println(users);
    }
}
