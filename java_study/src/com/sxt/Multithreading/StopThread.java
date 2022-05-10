package com.sxt.Multithreading;

import java.io.IOException;
//终止线程
public class StopThread implements Runnable {

    public boolean flag = true;
    @Override
    public void run() {
        int number = 0;
        System.out.println(Thread.currentThread().getName()+"线程开始");
        while (flag){
            System.out.println(Thread.currentThread().getName()+"*****"+number);
            number++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"线程结束");
    }
    public void Stop(){
        this.flag = false;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(Thread.currentThread().getName()+"主线程开始");
        StopThread stopThread = new StopThread();
        Thread t1 = new Thread(stopThread,"测试线程TestThread");
        t1.start();
        System.in.read();//IO流的阻塞，必须输入了之后才会停止
        stopThread.Stop();
        System.out.println(Thread.currentThread().getName()+"主线程结束");
    }
}
