package com.frank.jian.fanxing;
//泛型的方法
public class MethodGeneric {

    public <T> void printName(T name){
        System.out.println(name);
    }
    public <T> T ReturnName(T name){
        return name;
    }

    //静态泛型方法
    public static <T> void StaMethod(T name){
        System.out.println(name);

    }
    public static <T> T StaReMethod(T name){
        return name;
    }
//泛型方法与可变参数，处理数组
    public <T> void CanShu(T...args){
        for (T t: args) {
            System.out.println(t);
        }
    }

    //无界通配符
    public void showFlag(Generic<?> generic){
        System.out.println(generic.getFlag());

    }
    public void showFlag1(Generic<? extends Number> generic){
        System.out.println(generic.getFlag());

    }

}
