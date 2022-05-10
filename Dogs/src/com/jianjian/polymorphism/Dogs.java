package com.jianjian.polymorphism;

public class Dogs extends Animals {
    @Override
    public void shout() {
//        super.shout();
        System.out.println("汪汪汪~~~");
    }


    public void seeDoor() {
//
        System.out.println("Dogs看门");
    }
}
