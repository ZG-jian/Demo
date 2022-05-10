package com.jianjian.polymorphism;

public class Cats extends Animals {
    @Override
    public void shout() {
//        super.shout();
        System.out.println("喵喵喵喵~~~~");
    }
}
