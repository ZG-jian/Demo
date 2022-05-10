package com.jian.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

@Aspect//一定要添加，指定当前对象为切面对象
@Order(2)
public class MyAspect2 {

    /**
     * 配置切点
     */
    @Pointcut("execution(* com.jian.service.*.*(..))")
    public void myPointcut(){

    }

    /**
     * 前置通知,有一个value，就是配置切点的,只有一个参数不写前面也行
     * @param joinPoint
     */
    //@Before("execution(* com.com.jian.service.*.*(..))")
    //@Before(value = "execution(* com.com.jian.service.*.*(..))")
    @Before("myPointcut()")
    public void MyBefore(JoinPoint joinPoint){
        System.out.println("Before2....  "+joinPoint.getSignature().getName());
    }

    /**
     * 后置通知
     * @param joinPoint
     */
//    @AfterReturning("execution(* com.com.jian.service.*.*(..))")
    @AfterReturning("myPointcut()")
    public void myAspectReturning(JoinPoint joinPoint){
        System.out.println("AfterReturning2....."+joinPoint.getSignature().getName());
    }

    /**
     * 环绕通知
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
//    @Around("execution(* com.com.jian.service.*.*(..))")
    @Around("myPointcut()")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("AroundBefore2....");
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("AroundAfter2.....");
        return obj;
    }

    /**
     * 最终通知
     */
//    @After("execution(* com.com.jian.service.*.*(..))")
    @After("myPointcut()")
    public void myAfter(){
        System.out.println("最终通知2");
    }

    /**
     * 异常通知
     * @param e
     */
//    @AfterThrowing(value = "execution(* com.com.jian.service.*.*(..))",throwing = "e")
    @AfterThrowing(value = "myPointcut()",throwing = "e")
    public void myAfterThrowing(Exception e){
        System.out.println("Exception2:  "+e);
    }
}
