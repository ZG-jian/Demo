package com.jian.cglibproxy;

public class Test {
    public static void main(String[] args) {
        CglibProxyRent rent = new CglibProxyJian();
        CglibProxyRent rent1 = (CglibProxyRent) CglibProxyBeanFactory.getProxyBean(rent);
        rent1.renting();
    }
}
