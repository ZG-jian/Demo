package com.jian.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * 案例就接口都实现，实际开发就是选择性实现
 */
public class MyAspect implements MethodBeforeAdvice, AfterReturningAdvice, MethodInterceptor, ThrowsAdvice {
    /**
     * 前置通知
     * @param method 目标方法对象
     * @param objects 目标方法的参数列表
     * @param o 目标对象
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before......"+method.getName());
    }

    /**
     * 后置通知
     * @param o 目标方法的返回值
     * @param method 目标方法对象
     * @param objects 目标方法的参数列表
     * @param o1 目标对象
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("After......"+method.getName());
    }

    /**
     * 环绕通知    调用目标方法之前和之后都做通知
     * @param methodInvocation  目标方法对象（封装到当中了）
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Around.......Before"+methodInvocation.getMethod().getName());
        //执行目标方法
        Object obj = methodInvocation.proceed();
        System.out.println("Around.......After"+methodInvocation.getMethod().getName());
        return obj;
    }

    public void afterThrowing(Exception ex){
        System.out.println(ex.getMessage());
    }
}
