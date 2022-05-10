package com.sxt.Multithreading;

import com.frank.jian.Trowable.Test;
//以继承方式操作多线程
public class TestThread1 extends Thread {
    public TestThread1(String name) {
        super(name);
    }

    public TestThread1() {
    }

    @Override
    public void run() {
        System.out.println(this.getName()+" 线程开始");
        for (int i = 0; i < 20 ; i++) {
            System.out.println(i);
        }
        System.out.println(this.getName()+" 线程结束");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"主线程开始");
        TestThread1 t1 = new TestThread1();
        t1.start();
        System.out.println(Thread.currentThread().getName()+"主线程结束");

    }
}
