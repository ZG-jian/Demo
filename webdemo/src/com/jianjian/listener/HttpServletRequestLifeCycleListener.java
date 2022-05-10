package com.jianjian.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * HttpServletRequest对象生命周期监听器
 */
public class HttpServletRequestLifeCycleListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println((HttpServletRequest)sre.getServletRequest());
        System.out.println("HttpServletRequest.....Destroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println((HttpServletRequest)sre.getServletRequest());
        System.out.println("HttpServletRequest.....Initialized");
    }
}
