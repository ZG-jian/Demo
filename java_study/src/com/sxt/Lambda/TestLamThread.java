package com.sxt.Lambda;
/*
Lambda表达式创建线程
 */
public class TestLamThread {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"线程开始");

/* 完整格式是这样的，下面是简写
       Runnable runnable = ()->{};
        new Thread(runnable,"Lambda Thread");*/
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
        },"Lambda Thread").start();

        System.out.println(Thread.currentThread().getName()+"线程结束");
    }
}
