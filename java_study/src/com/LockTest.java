package com;

import java.util.concurrent.locks.ReentrantLock;


    /*
解决线程安全问题的方式三：Lock锁   ---  JDK5.0新增的一种方式
 */
    class Window implements  Runnable{
        private int ticker = 100;
        //1、实例化ReentrantLock
        private ReentrantLock lock = new ReentrantLock(true);
        @Override
        public void run() {
            while (true){
                try{
                    //2、调用锁定方法lock()
                    lock.lock();//加锁
                    if(ticker > 0){
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + ":售票，票号为：" + ticker);
                        ticker--;
                    }else {
                        break;
                    }
                }finally {
                    //3、调用解锁方法
                    lock.unlock();
                }
            }
        }
    }

    public class LockTest {
        public static void main(String[] args) {
            Window w1 = new Window();
            Thread t1 = new Thread(w1);
            Thread t2 = new Thread(w1);
            Thread t3 = new Thread(w1);
            t1.setName("窗口1");
            t2.setName("窗口2");
            t3.setName("窗口3");
            t1.start();
            t2.start();
            t3.start();
        }
    }

