package com.jian.cglibproxy;

public class CglibMyAspect {
    public void before(){
        System.out.println("带领客户看房，签订租房协议");
    }
    public void after(){
        System.out.println("售后服务");
    }
}
