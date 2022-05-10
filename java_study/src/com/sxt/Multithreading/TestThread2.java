package com.sxt.Multithreading;

import com.frank.jian.Trowable.Test;
//通过实现接口形式操作多线程
public class TestThread2 implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"线程开始");

        for (int i = 0; i < 20; i++) {
            System.out.println(i);
        }
        System.out.println(Thread.currentThread().getName()+"线程结束");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"主线程开始");
        TestThread2 testThread2 = new TestThread2();
        Thread t2 = new Thread(testThread2);
        t2.start();
        System.out.println(Thread.currentThread().getName()+"主线程结束");
    }
}
