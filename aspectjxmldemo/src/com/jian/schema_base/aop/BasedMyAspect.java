package com.jian.schema_base.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class BasedMyAspect implements MethodBeforeAdvice, AfterReturningAdvice, MethodInterceptor, ThrowsAdvice {
    /**
     * 前置通知
     * @param method
     * @param objects
     * @param o
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before.....");
    }

    /**
     * 环绕通知
     * @param methodInvocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Around.....Before");
        Object obj = methodInvocation.proceed();
        System.out.println("Around......After");
        return obj;
    }

    /**
     * 后置通知
     * @param o
     * @param method
     * @param objects
     * @param o1
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("After......");
    }

    /**
     * 异常通知
     * @param ex
     */
    public void afterThrowing(Exception ex){
        System.out.println("Exception: "+ex);
    }

}
