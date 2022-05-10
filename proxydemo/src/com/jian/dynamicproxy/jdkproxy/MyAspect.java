package com.jian.dynamicproxy.jdkproxy;

/**
 * 对目标对象增强
 */
public class MyAspect {
    public void before(){
        System.out.println("带领房客看房签租房协议");
    }
    public void after(){
        System.out.println("售后服务");
    }
}
