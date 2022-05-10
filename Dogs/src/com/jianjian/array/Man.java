package com.jianjian.array;

public class Man {
    private int age;
    private String name;

    public Man(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return age+"\t"+name;
    }
}
