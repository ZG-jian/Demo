package com.jianjian.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 第一个Filter案例
 * 除了名字不一样，配置其实几乎都是一样的
 *
 * 配置的url为/suibian/*，就是访问的servlet跟此url匹配时，过滤
 */
public class FirstFilter implements Filter {
    /**
     * 初始化方法，当Filter对象创建后会调用一次该方法
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("Filter-----Init........");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("预处理请求");
        //对请求做放行处理
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("预处理响应");

    }

    /**
     * 当Filter被销毁时会调用一次该方法
     */
    @Override
    public void destroy() {

    }
}
