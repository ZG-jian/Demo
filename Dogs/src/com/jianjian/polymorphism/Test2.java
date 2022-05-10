package com.jianjian.polymorphism;

public class Test2 {
    public static void main(String[] args) {
        Animals a = new Dogs();
        //向下转型中使用 instanceof
        if(a instanceof Dogs){
            Dogs dogs = (Dogs)a;
            dogs.seeDoor();
        }
    }
}
