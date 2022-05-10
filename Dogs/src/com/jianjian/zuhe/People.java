package com.jianjian.zuhe;

public class People {
    String name;
    int age;
    public void rest(){
        System.out.println("FFFFFFFFFFFFFuck");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
class Teacher{
    People people = new People();
    private double salary;

    public Teacher(String name, int age, double salary) {
        this.people.name = name;
        this.people.age = age;
        this.salary = salary;
    }

    public static void main(String[] args) {
        Teacher zhaoYan = new Teacher("牛批clus",50,3500.0);
        zhaoYan.people.rest();
        System.out.println(zhaoYan.people.age);
        zhaoYan.people.setAge(666);
        zhaoYan.people.age = 6688;
        System.out.println(zhaoYan.people.age);
        //这tmd就是组合
    }
}
