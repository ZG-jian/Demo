package com.sxt.Multithreading;
//线程冲突案例
/*
多次跑后才出现以下结果，体现最明显，也有余额不足的显示
法外狂徒张三取8888.0元成功
李四取6666.0元成功
	  余额为：3334.0
	  余额为：-5554.0
 */

//加了synchronized之后同步正常了，当李四操作另一个账户就变成没有线程冲突，因为不是同一个对象
public class AccountThread {
    public static void main(String[] args) {
        Account account = new Account("张三的账户",10000);
        Account account1 = new Account("李四的账户",20000);
        System.out.println(account.getAccountName()+"有"+account.getAccountMoney()+"元");
        System.out.println(account1.getAccountName()+"有"+account1.getAccountMoney()+"元");
        getMoney g1 = new getMoney(account,8888);
        getMoney g2 = new getMoney(account1,6666);
        Thread t1 = new Thread(g1,"法外狂徒张三");
        Thread t11 = new Thread(g1,"法外狂徒张三的老婆");
        Thread t2 = new Thread(g2,"李四");
        Thread t22 = new Thread(g2,"李四的老婆");
        t1.start();
        t2.start();

        //有同步，尝试冲突
        t11.start();
        t22.start();

    }
}
//账户类
class Account{
    //账户名字
    private String accountName;
    //账户的余额
    private double accountMoney;

    public Account() {
    }

    public Account(String accountName, double accountMoney) {
        this.accountName = accountName;
        this.accountMoney = accountMoney;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getAccountMoney() {
        return accountMoney;
    }

    public void setAccountMoney(double accountMoney) {
        this.accountMoney = accountMoney;
    }
}
/*
取钱线程
 */
class getMoney implements Runnable{
private Account account ;
private double money;

    public getMoney(Account account, double money) {
        this.account = account;
        this.money = money;
    }

    @Override
    public void run() {
        synchronized (this.account) {
            if (this.account.getAccountMoney() >= money) {
                System.out.println(Thread.currentThread().getName() + "取" + money + "元成功");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //更新余额
                this.account.setAccountMoney(this.account.getAccountMoney() - money);
                System.out.println(this.account.getAccountName() + "的余额为：" + this.account.getAccountMoney());
            } else {
                System.out.println(Thread.currentThread().getName() + "取钱失败，余额不足。");
            }
        }
    }
}