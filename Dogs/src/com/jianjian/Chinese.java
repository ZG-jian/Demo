package com.jianjian;

public class Chinese implements Human {
    //接口的实现
    @Override
    public void eat() {
        System.out.println("中国人吃中国菜");
    }

    @Override
    public void sleep() {
        System.out.println("熬夜修仙不睡觉");
    }
}
