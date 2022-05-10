package com.jianjian.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ServletContextAttrListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("--------Add start-----------------");
        System.out.println(scae.getName()+"-----"+scae.getValue());
        System.out.println(scae.getServletContext());
        System.out.println("--------Add end-----------------");

    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println("--------Removed start-----------------");
        System.out.println(scae.getName()+"-----"+scae.getValue());
        System.out.println(scae.getServletContext());
        System.out.println("--------Removed end-----------------");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println("--------Replaced start-----------------");
        System.out.println(scae.getName()+"-----"+scae.getValue());
        System.out.println(scae.getServletContext());
        System.out.println("--------Replaced end-----------------");
    }
}
