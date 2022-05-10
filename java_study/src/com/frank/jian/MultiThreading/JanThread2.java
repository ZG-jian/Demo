package com.frank.jian.MultiThreading;

public class JanThread2 implements Runnable {
    @Override
    public void run() {
        while (true){
            System.out.println("JanThread2......Thread"+Thread.currentThread().getName());
        }
    }
}
