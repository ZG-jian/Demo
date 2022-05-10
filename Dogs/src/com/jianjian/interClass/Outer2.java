package com.jianjian.interClass;
/*
静态内部类
 */
public class Outer2 {

        private int a = 10;
        private static int b = 20;
        public void show(){
            System.out.println(b);
        }
        //相当于外部类的一个静态成员
        static class Inner2{
            private int number = 6666;
            public void test(){
// System.out.println(a);
// 静态内部类不能访问外部类的通属性

                System.out.println(b);
                //静态内部类可以访问外部类的静属性
            }
        }
}

