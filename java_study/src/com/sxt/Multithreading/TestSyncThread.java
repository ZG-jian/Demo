package com.sxt.Multithreading;

public class TestSyncThread {
    public static void main(String[] args) {
        //锁this 执行代码
        //this作为线程对象锁
//        Programmer p = new Programmer("张三");
//        new Working1(p).start();//Working1是打开电脑的工作线程
//        new Working2(p).start();//Working2是开始编码的工作线程
        /**无同步锁输出
         * 张三接通电源
         * 张三双击idea
         * 张三idea启动完毕
         * 张三按开机按键
         * 张三系统启动中
         * 张三开开心心写代码
         * 张三系统启动成功
         */

        //常量串作为线程对象锁演示（锁字符串执行代码）
        /*
        对这样的问题我们需要所有的线程都有互斥性
        这个时候，锁this就没有用了，无互斥效果，因为是不同的对象
        线程当中的对象锁就可以用常量串来执行
         */
//        Programmer p = new Programmer("张三");
//        Programmer p1 = new Programmer("李四");
//        new WCThread(p).start();
//        new WCThread(p1).start();


        /*
        领奖一个个，一起看见别人，不好
        锁Class
        如果在多个线程里操作的对象是Programmer实例化出来的对象，那么他们是有互斥效果的
         */
//        Programmer p = new Programmer("张三");
//        Programmer p1 = new Programmer("李四");
//        new  ProgrammerMoney(p).start();
//        new  ProgrammerMoney(p1).start();
//
//        //销售领年终奖
//        Sale sale = new Sale("小红");
//        Sale sale1 = new Sale("小美");
//        new SaleMoney(sale).start();
//        new SaleMoney(sale1).start();

//
        //Class对象是不同的，线程不互斥，拿的不是相同的对象锁
//        Programmer p = new Programmer("张三");
//        new  ProgrammerMoney(p).start();
//        Sale sale = new Sale("小红");
//        new SaleMoney(sale).start();
//        //当把synchronized加到money方法的public前时，把this.name改成获取当前线程名，那么对象锁就是当前这个类的Class对象

        /*
        可以在经理类中的cheers方法里锁this，因为多个线程操作同一个经理对象
        也可以在线程类当中·用synchronized实现线程的同步
        就是在线程类的run方法里锁调用
         */
        Manager manager = new Manager("张三丰");
        new CheersThread(manager,"张三").start();
        new CheersThread(manager,"李四").start();
    }
}








/*
定义程序员类
 */
class Programmer {
    private String name;

    public Programmer(String name) {
        this.name = name;
    }
//computer与coding方法互斥
    //锁this,不同线程中，相同对象的synchronized会互斥
    //   Programmer p = new Programmer("张三");
//        new Working1(p).start();
//        new Working2(p).start();
    /*
    启动电脑
     */
    public void computer() {
        synchronized (this) {
            try {
                System.out.println(this.name + "接通电源");
                Thread.sleep(500);
                System.out.println(this.name + "按开机按键");
                Thread.sleep(500);
                System.out.println(this.name + "系统启动中");
                Thread.sleep(500);
                System.out.println(this.name + "系统启动成功");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    编码
     */
    public void coding() {
        synchronized (this) {
            try {
                System.out.println(this.name + "双击idea");
                Thread.sleep(500);
                System.out.println(this.name + "idea启动完毕");
                Thread.sleep(500);
                System.out.println(this.name + "开开心心写代码");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //上厕所
    public void WC(){
        synchronized ("") {
            try {
                System.out.println(this.name + "打开卫生间的门");
                Thread.sleep(500);
                System.out.println(this.name + "开始上厕所");
                Thread.sleep(500);
                System.out.println(this.name + "完事冲水");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void money(){
        //锁Class
        synchronized (Programmer.class) {
            try {
                System.out.println(this.name + "被领导表扬");
                Thread.sleep(500);
                System.out.println(this.name + "拿奖金");
                Thread.sleep(500);
                System.out.println(this.name + "对公司表示感谢后走人");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


/*
定义销售员类
 */

class Sale{
    private String name;

    public Sale(String name) {
        this.name = name;
    }

    public void money(){
        //锁Class
        synchronized (Sale.class) {
            try {
                System.out.println(this.name + "被领导表扬");
                Thread.sleep(500);
                System.out.println(this.name + "拿奖金");
                Thread.sleep(500);
                System.out.println(this.name + "对公司表示感谢后走人");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/*
定义经理类
 */
class Manager{
    private String name;

    public Manager(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    /*
    敬酒
     */
    public void Cheers(String mName, String eName){

            try {
                System.out.println(mName + "来到" + eName + "面前");
                Thread.sleep(500);
                System.out.println(eName + "拿起酒杯");
                Thread.sleep(500);
                System.out.println(mName + "和" + eName + "干杯");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
}




/*
   打开电脑的工作线程
    */
class Working1 extends Thread {
    private Programmer p;

    public Working1(Programmer p) {
        this.p = p;
    }

    @Override
    public void run() {
        this.p.computer();
    }
}

/*
写代码的工作线程
 */
class Working2 extends Thread {
    private Programmer p;

    public Working2(Programmer p) {
        this.p = p;
    }

    @Override
    public void run() {
        this.p.coding();
    }
}
/*
上厕所线程类
*/
class WCThread extends Thread{
    private Programmer p;

    public WCThread(Programmer p) {
        this.p = p;
    }
    @Override
    public void run() {
        this.p.WC();
    }
}
/*
程序员技术部拿奖金线程类
 */
class ProgrammerMoney extends Thread{
    private Programmer p;

    public ProgrammerMoney(Programmer p) {
        this.p = p;
    }

    @Override
    public void run() {
        this.p.money();
    }
}


/*
销售部取年终奖线程
 */
class SaleMoney extends Thread{
    private Sale p;

    public SaleMoney(Sale p) {
        this.p = p;
    }

    @Override
    public void run() {
        this.p.money();
    }
}


/*
经理敬酒线程
 */
class CheersThread extends Thread{
    private Manager manager;
    private String name;

    public CheersThread(Manager manager, String name) {
        this.manager = manager;
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (this.manager) {
            this.manager.Cheers(manager.getName(), name);
        }
    }
}
