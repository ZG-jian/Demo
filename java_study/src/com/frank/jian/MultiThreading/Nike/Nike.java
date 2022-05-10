package com.frank.jian.MultiThreading.Nike;

public class Nike {
    public static void main(String[] args) {
        NikeThread nikeThread = new NikeThread();
        DamonThread damonThread = new DamonThread();
        //后台线程--守护线程
        //用来更新，鞋子卖光了？
        Thread dThread = new Thread(damonThread);
        dThread.setDaemon(true);
        dThread.start();


        //前台线程
        new Thread(nikeThread,"法外狂徒张三").start();
        new Thread(nikeThread,"妇科圣手李四").start();
        new Thread(nikeThread,"江洋大盗王五").start();

    }
}
