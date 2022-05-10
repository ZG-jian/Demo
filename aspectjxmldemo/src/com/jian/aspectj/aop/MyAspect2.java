package com.jian.aspectj.aop;

import org.aspectj.lang.JoinPoint;

public class MyAspect2 {
    public void myAspectBefore(JoinPoint joinPoint){
        System.out.println("MyAspect2  Before"+joinPoint.getSignature().getName());
    }
}
