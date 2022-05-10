package com.jian.web.filter;

import com.jian.commons.Constants;
import com.jian.pojo.Users;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 判断当前客户端浏览器是否登录的Filter
 * 这里对静态资源要求不严，就不拦截，别的项目要是严就拦。
 * 有两个动态资源必须放行，login.do，login.jsp，没登陆也得放行，总得让他去登录呀
 */
@WebFilter(urlPatterns = {"*.do","*.jsp"})
public class UserLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;//强转一下
        String uri = request.getRequestURI();
        //判断当前请求的是否为login.jsp或者login.do  是用户登录的资源就放行
        if (uri.indexOf("longin.jsp")!=-1||uri.indexOf("login.do")!=-1||uri.indexOf("validateCode.do")!=-1){
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            //说明请求的不是login.jsp或者login.do ，那就得判断有没有登录
            HttpSession session = request.getSession();
            Users users = (Users) session.getAttribute(Constants.USER_SESSION_kEY);
            if (users!=null){
                filterChain.doFilter(servletRequest, servletResponse);
            }else {
                request.setAttribute(Constants.REQUEST_MSG,"不登陆不好使");
                //跳回登录页面
                request.getRequestDispatcher("login.jsp").forward(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
