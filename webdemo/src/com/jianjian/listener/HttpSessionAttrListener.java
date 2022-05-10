package com.jianjian.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;


public class HttpSessionAttrListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println("----HttpSession----Add start-----------------");
        System.out.println(se.getName()+"------"+se.getValue());
        System.out.println(se.getSession());
        System.out.println("----HttpSession----Add end-----------------");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println("----HttpSession----Removed start-----------------");
        System.out.println(se.getName()+"------"+se.getValue());
        System.out.println(se.getSession());
        System.out.println("----HttpSession----Removed end-----------------");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        System.out.println("----HttpSession----Replaced start-----------------");
        System.out.println(se.getName()+"------"+se.getValue());
        System.out.println(se.getSession());
        System.out.println("----HttpSession----Replaced end-----------------");
    }
}
