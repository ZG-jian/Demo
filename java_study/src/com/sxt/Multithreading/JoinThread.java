package com.sxt.Multithreading;

public class JoinThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <9 ; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"    "+i);
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new JoinThread(),"第一个子线程");
        Thread t2 = new Thread(new JoinThread());
        t1.start();
        for (int i = 0; i <9 ; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"    "+i);
            if (i == 2){
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
