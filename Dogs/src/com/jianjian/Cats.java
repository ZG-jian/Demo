package com.jianjian;

public class Cats extends Animals{
    public Cats() {
    }

    public Cats(int age, String name, String varieties, String food) {
        super(age, name, varieties, food);
    }

    public Cats(int age, String name) {
        super(age, name);
    }

    @Override
    public void braking() {
//        super.braking();
        //抽象方法必须重写
        System.out.println("喵喵喵！");
    }
}
