package com.sxt.Multithreading;
//跑起来也是很多次1先，让步失败
public class YieldThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <30 ; i++) {
            if ("线程111111".equals(Thread.currentThread().getName())){
                if (i ==0){
                    Thread.yield();
                }
            }
            System.out.println(Thread.currentThread().getName()+"     "+i);
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new YieldThread(),"线程111111");
        Thread t2 = new Thread(new YieldThread(),"线程222222");
        t1.start();
        t2.start();
    }
}
