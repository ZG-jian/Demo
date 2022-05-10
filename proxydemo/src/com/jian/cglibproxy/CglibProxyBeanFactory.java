package com.jian.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyBeanFactory {
    public static Object getProxyBean(CglibProxyRent rent){
        CglibMyAspect myAspect = new CglibMyAspect();
        Enhancer enhancer =new Enhancer();//完成创建代理对象前的一些设置的对象
        enhancer.setSuperclass(rent.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            /**
             *
             * @param o 代理对象的引用
             * @param method 目标对象的方法对象
             * @param objects 目标方法的参数列表
             * @param methodProxy 目标方法的方法对象的代理对象
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                myAspect.before();
                Object obj = method.invoke(rent, objects);
                myAspect.after();
                return obj;
            }
        });
                return enhancer.create();
    }
}
