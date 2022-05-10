package com.frank.jian.MultiThreading;
//继承方式
public class JanThread1 extends Thread{
    @Override
    public void run() {
        while (true){
            System.out.println("Jan.......Thread1");
        }
    }
}
