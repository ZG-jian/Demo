package com.jianjian;

public class Testif2 {
    public static void main(String[] args) {
    int a = (int)(Math.random()*100);
        System.out.println(a);
        if(a<18)
            System.out.println("还小，可以随便玩");
        else if(a<25)
            System.out.println("青年了，该学习一些知识了");
        else if(a<35)
            System.out.println("该工作了");
        else if(a<60)
            System.out.println("快退休了");
        else
            System.out.println("养老吧你！");
    }
}
