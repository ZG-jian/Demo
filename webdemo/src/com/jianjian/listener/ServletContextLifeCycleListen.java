package com.jianjian.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ServletContext对象生命周期监听器
 * 要去web.xml中配置
 * 就不在这做对全局容器ServletContext对象的处理了
 */
public class ServletContextLifeCycleListen implements ServletContextListener {
    /**
     * 实现两个抽象方法
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //获取ServletContext对象
        ServletContext servletContext = sce.getServletContext();
        System.out.println(servletContext);
//一启动tomcat就会
        System.out.println("ServletContext Init.......");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //获取ServletContext对象
        ServletContext servletContext = sce.getServletContext();
        System.out.println(servletContext);
        //在bin目录下使用bat关闭才能看见
        System.out.println("ServletContext  Destroy....");
    }
}
