package com.frank.jian.MultiThreading.Nike;

public class DamonThread implements Runnable{
    @Override
    public void run() {
        System.out.println("守护线程...........");
    }
}
