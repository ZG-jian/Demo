package com.sxt.Multithreading;

public class ManToMain {
    public static void main(String[] args) {
        SyncSTack syncSTack = new SyncSTack();
        //因为太快了，生产线程先启动会生产完才消费
        //所以要把消费线程放在前面先启动
        new XiaoFei(syncSTack).start();
        new ShengChan(syncSTack).start();
        /**
         * 太快了，跑很多次都是生产满了才全消费，需要调换线程开始顺序
         * 就算调换顺序都有先生产完再消费
         * 成功例：生产第0个馒头
         * 生产第1个馒头
         * 生产第2个馒头
         * 生产第3个馒头
         * 消费了第0个馒头
         * 生产第4个馒头
         * 生产第5个馒头
         * 生产第6个馒头
         * 消费了第1个馒头
         * 生产第7个馒头
         * 生产第8个馒头
         * 生产第9个馒头
         * 消费了第2个馒头
         * 消费了第3个馒头
         * 消费了第4个馒头
         * 消费了第5个馒头
         * 消费了第6个馒头
         * 消费了第7个馒头
         * 消费了第8个馒头
         * 消费了第9个馒头
         */
    }
}
/*
创建馒头类
 */
class ManTo {
    private int id;

    public ManTo(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
/*
定义缓冲区类
 */
class SyncSTack{
    //定义存放馒头的盒子
    private ManTo[] mt = new ManTo[10];
    //定义操作盒子的索引
    private int index;


    /*
    放馒头
     */
    public synchronized void putManTo(ManTo manTo){
        //判断盒子有没有满
        while (this.index == this.mt.length){
            try {
                /*
                语法：wait()必须在synchronized块中调用
                wait执行后，线程会将持有的对象锁释放，并进入阻塞状态
                其他需要改对象锁的线程就可以继续执行了
                 */
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        /*
        唤醒取馒头的线程

         */
        this.notify();

        this.mt[this.index] = manTo;
        index++;
    }
    /*
    取馒头
     */
    public synchronized ManTo getManTo(){
        while (this.index == 0){
            try {
                /*
                语法：wait()必须在synchronized块中调用
                wait执行后，线程会将持有的对象锁释放，并进入阻塞状态
                其他需要改对象锁的线程就可以继续执行了
                 */
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //唤醒拿馒头线程
        this.notify();

        index--;
        return this.mt[this.index];
    }
}

/**
 * 定义生产者线程类
 */
class ShengChan extends Thread{
    private SyncSTack ss;

    public ShengChan(SyncSTack ss) {
        this.ss = ss;
    }

    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println("生产第"+i+"个馒头");
            ManTo manTo  = new ManTo(i);
            this.ss.putManTo(manTo);
        }
    }
}
class XiaoFei extends Thread{
    private SyncSTack ss;

    public XiaoFei(SyncSTack ss) {
        this.ss = ss;
    }

    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
        ManTo manTo = this.ss.getManTo();
            System.out.println("消费了第"+i+"个馒头");
        }
    }
}
