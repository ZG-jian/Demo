package com.jianjian.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 在Filter中设置响应编码
 */
public class EncodingFilter implements Filter {
    private String coding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (this.coding == null){
            //没读到就给默认的
            servletRequest.setCharacterEncoding("utf-8");
        }else {
            //读到了就设置读到的，就是给定了就按照你给定的
            servletRequest.setCharacterEncoding(this.coding);
        }

        //不要在这doFilter这句下面设置响应编码
        /**
         * 1.在下面设置已经晚了，已经产生了响应
         * 2.就算是在doFilter前设置也不推荐，因为不知道浏览器的默认编码，
         * 可能还是乱码，所以响应编码最好在servlet中设置，这样才灵活
         */
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
