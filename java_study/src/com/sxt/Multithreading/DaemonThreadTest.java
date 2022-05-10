package com.sxt.Multithreading;
//守护线程随着用户线程死亡而死亡
class DaemonThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <20 ; i++) {
            System.out.println(Thread.currentThread().getName()+"  "+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class UserThread implements Runnable{

    @Override
    public void run() {
        Thread thread = new Thread(new DaemonThread(),"守护线程");
        //将该线程设置为守护线程
        thread.setDaemon(true);
        thread.start();
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+"  "+i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class DaemonThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new UserThread(),"UserThread");
        thread.start();
       Thread.sleep(1000);
        System.out.println("主线程结束");
    }
}
