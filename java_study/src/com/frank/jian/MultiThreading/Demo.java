package com.frank.jian.MultiThreading;

public class Demo {
    public static void main(String[] args) {
        //继承方式
//        JanThread1 jan  = new JanThread1();
//        jan.start();
        //实现接口方式
        JanThread2 jan2 = new JanThread2();
     new Thread(jan2,"ohhhhhhhhhhhhThread").start();



//start会多开启一个线程
        while (true){
            System.out.println("main...... Thread");
        }
    }
}
