package com.jian.dynamicproxy.jdkproxy;

public class JdkProxyTest {
    public static void main(String[] args) {
        JdkProxyRent jdkProxyRent = new JdkProxyJian();
        JdkProxyRent jdkProxyRent1 = (JdkProxyRent) JdkProxyFactory.getProxyBean(jdkProxyRent);
        jdkProxyRent1.renting();
    }
}
