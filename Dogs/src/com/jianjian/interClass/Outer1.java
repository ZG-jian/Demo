package com.jianjian.interClass;

public class Outer1 {
    private int age = 10;

    public void show() {
        System.out.println("Outer1:"+age);
    }
/*
内部类
 */
    public class Inner1 {
        private int age = 20;

        public void show() {
            System.out.println(age);
            System.out.println("*****");
            Outer1.this.show();
            System.out.println(Outer1.this.age);
        }
    }

}

