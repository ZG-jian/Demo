package com.sxt.Multithreading;

class AliveThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().isAlive()+"     AliveThread线程里");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class Alive {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new AliveThread());
        System.out.println(thread.isAlive()+"    未start  1");
        thread.start();
        System.out.println(thread.isAlive()+"    start后2");
        Thread.sleep(1000);
        System.out.println(thread.isAlive()+"    主线程休眠1s后");
        System.out.println(Thread.currentThread().getName()+"主线程结束");
        System.out.println("主线程结束后："+thread.isAlive());
    }
}
