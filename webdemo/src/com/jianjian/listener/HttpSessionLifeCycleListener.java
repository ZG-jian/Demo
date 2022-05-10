package com.jianjian.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HttpSessionLifeCycleListener implements HttpSessionListener {
    /**
     * 当我们去调用了request.getSession并且
     * 与客户端浏览器没有对应的Session的时候Tomcat就帮我们创建Session对象
     * 创建完Session以后这个方法就会立即执行
     * @param se
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println(se.getSession());
        System.out.println("Http Session Create");
    }

    /**
     * 这个方法的调用时间：
     * 1.当Session超时了
     * 2.调用Session的invalidate()方法时
     * 销毁之前就会调用这个方法
     * 关浏览器只是没有了Session对应的状态cookieId
     * @param se
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println(se.getSession());
        System.out.println("Http Session Destroyed");
    }
}
