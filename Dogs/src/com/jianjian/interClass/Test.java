package com.jianjian.interClass;

public class Test {
    public static void main(String[] args) {
        //测试非静态内部类
        Outer1.Inner1 inner1 = new Outer1().new Inner1();
        //先创建外部类实例，然后使用该外部类实例创建内部类实例
        inner1.show();
        System.out.println("---------");

        Outer2.Inner2 inner2 = new Outer2.Inner2();
        inner2.test();
//静态内部类
        Outer2 outer2 = new Outer2();
        outer2.show();
    }
}
