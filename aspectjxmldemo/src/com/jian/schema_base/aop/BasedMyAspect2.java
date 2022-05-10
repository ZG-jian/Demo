package com.jian.schema_base.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class BasedMyAspect2 implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("BasedMyAspect2...Before");
    }
}
