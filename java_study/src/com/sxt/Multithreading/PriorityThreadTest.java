package com.sxt.Multithreading;
//线程的优先级，并不是设置了就会优先，只是概率会高点
class PriorityThread implements  Runnable{
private boolean flag = true;
private int number = 0;
    @Override
    public void run() {
        while (flag){
            System.out.println(Thread.currentThread().getName()+number++);
        }
    }
    public void stop(){
        this.flag = false;
    }
}
public class PriorityThreadTest {
    public static void main(String[] args) throws InterruptedException {
            PriorityThread p1 = new PriorityThread();
            PriorityThread p2 = new PriorityThread();
            Thread t1 = new Thread(p1,"第一个线程");
            Thread t2 = new Thread(p1,"第二个线程");
            t1.setPriority(Thread.MAX_PRIORITY);//将第一个线程的优先级设置为最高
            t2.setPriority(Thread.MIN_PRIORITY);//将第二个线程的优先级设置为最低
            t1.start();
            t2.start();
            Thread.sleep(1000);
            p1.stop();
            p2.stop();
    }
}
