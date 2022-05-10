package com.jianjian.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * HttpServletRequest属性操作监听器
 */
@WebListener
public class HttpServletRequestAttrListener implements ServletRequestAttributeListener {
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        System.out.println("----HttpServletRequestAttr----Added start-----------------");
        System.out.println(srae.getName()+"------"+srae.getValue());
        System.out.println((HttpServletRequest)srae.getServletRequest());
        System.out.println("----HttpServletRequestAttr----Added end-----------------");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        System.out.println("----HttpServletRequestAttr----Removed start-----------------");
        System.out.println(srae.getName()+"------"+srae.getValue());
        System.out.println((HttpServletRequest)srae.getServletRequest());
        System.out.println("----HttpServletRequestAttr----Removed end-----------------");

    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println("----HttpServletRequestAttr----Replaced start-----------------");
        System.out.println(srae.getName()+"------"+srae.getValue());
        System.out.println((HttpServletRequest)srae.getServletRequest());
        System.out.println("----HttpServletRequestAttr----Replaced end-----------------");

    }
}
