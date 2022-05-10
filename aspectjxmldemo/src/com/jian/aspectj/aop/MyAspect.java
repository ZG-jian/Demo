package com.jian.aspectj.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 里面的方法叫什么名字都可以
 */
public class MyAspect {
    /**
     * 是不需要去实现通知类型的接口的，只要在切面中添加方法
     * 在配置aop的时候，才决定在什么类型下执行什么方法
     * @param joinPoint 对目标对象的封装
     */
    public void MyBefore(JoinPoint joinPoint){
/*        joinPoint.getTarget();//获取目标对象
        joinPoint.getSignature().getName();//获取目标方法方法名
        joinPoint.getArgs();//获取目标方法参数列表
        joinPoint.getThis();//获取代理对象*/
        System.out.println("Before"+joinPoint.getSignature().getName());
    }

    /**
     * 后置通知
     * @param joinPoint
     */
    public void MyAfterReturning(JoinPoint joinPoint){
        System.out.println("After......."+joinPoint.getSignature().getName());
    }

    /**
     * 环绕通知
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("Around Before"+proceedingJoinPoint.getSignature().getName());
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("Around After"+proceedingJoinPoint.getSignature().getName());
        return obj;
    }

    /**
     * 异常通知类型
     * @param e
     */
    public void myAfterThrowing(Exception e){
        System.out.println("Exception  "+e);
    }

    public void myAfter(){
        System.out.println("最终通知");
    }
}

