package com.jian.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class ToUppercaseAspect implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        //将username转换大写
        Object[] args = methodInvocation.getArguments();//获取参数列表，如果只有一个，就放0位置，有多个就按照参数位置放
        args[0] = ((String) args[0]).toUpperCase();
        Object obj = methodInvocation.proceed();//有返回值就拿到，没有就是空
        //没有后置通知需求就直接返回
        return obj;
    }
}
