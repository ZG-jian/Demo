package com.frank.jian.MultiThreading.Nike;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NikeThread implements Runnable {
    Object lock = new Object();
    //锁对象
    //synchronized (lock){}把while里面的内容在包起来
    /**
     * if (shoes>0) {
     * //线程不同步  线程不安全
     * try {
     * Thread.sleep(1000);
     * } catch (InterruptedException e) {
     * e.printStackTrace();
     * }
     * System.out.println(Thread.currentThread().getName() + "抢到了第" + (shoes--) + "双鞋子");
     * }
     * if (shoes<=0){
     * break;
     * }
     */

    ReentrantLock reentrantLock = new ReentrantLock();


    private int shoes = 10;

    @Override
    public void run() {
        while (true) {

                if (shoes > 0) {
                    synchronized (lock) {
                    //线程不同步  线程不安全
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "抢到了第" + (shoes--) + "双鞋子");

                    }

                    if (shoes < 0) {
                        break;
                    }
            }
        }
    }

    //要明白锁的对象是谁
    //如第一把锁属于谁，属于第一个用户，第一个线程，他抢到的

    //同步方法，推荐使用
    public synchronized void NikeCatch() {
        //同步代码块
        if (shoes > 0) {
            //线程不同步  线程不安全
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到了第" + (shoes--) + "双鞋子");
        }

    }
}
//lock同步锁跟synchronized的区别