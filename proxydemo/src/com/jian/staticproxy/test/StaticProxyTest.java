package com.jian.staticproxy.test;

import com.jian.staticproxy.Jian;
import com.jian.staticproxy.Rent;
import com.jian.staticproxy.StaticProxyRent;

public class StaticProxyTest {
    public static void main(String[] args) {
        Rent rent = new Jian();
        StaticProxyRent staticProxyRent = new StaticProxyRent(rent);
        staticProxyRent.renting();
    }
}
