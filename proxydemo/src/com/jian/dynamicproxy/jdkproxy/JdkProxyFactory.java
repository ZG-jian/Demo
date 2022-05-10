package com.jian.dynamicproxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyFactory {
    /**
     * 动态生成代理对象
     */
    public static Object getProxyBean(Object target){
        Class clazz = target.getClass();
        MyAspect myAspect = new MyAspect();
        //在JDK中动态生成代理对象的方法  1.目标对象的类加载器 2.实现的接口 3.用匿名内部类
        //
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new InvocationHandler() {
            /**
             * 动态生成代理对象中的方法。通用方法，比如A类这个方法叫a，B类这个方法叫b,都可以代理
             * 不知道代理对象的方法叫什么名，那就直接提供一个统一的方法invoke
             * @param proxy 动态生成的代理对象
             * @param method 调用目标方法的那个方法对象
             * @param args 传递到目标方法中的参数列表
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                myAspect.before();
                Object obj = method.invoke(target, args);
                myAspect.after();
                return obj;
            }
        });
    }
}
