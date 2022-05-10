package com.jian.web.filter;

import com.jian.pojo.Users;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //获取用户访问的uri
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        String uri = req.getRequestURI();
        //用户登录的资源肯定要放行
        //判断当前访问的URI是否是用户登录资源，如果是则放行
        if (uri.indexOf("login")!=-1||uri.indexOf("userLogin")!=-1){
            filterChain.doFilter(servletRequest,servletResponse);//放行
        }else {//访问的就不是用户登录的资源，然后就得判断是否登录了
            //跟之前的项目一样，把用户放到Session中了，拿到了就是登录了
            HttpSession session = req.getSession();
            Users user = (Users) session.getAttribute("user");
            if (user!=null&&user.getUsername().length()>0){
                filterChain.doFilter(servletRequest, servletResponse);
            }else {
                req.setAttribute("msg","请登录");
                req.getRequestDispatcher("login").forward(servletRequest, servletResponse);
            }
        }


    }

    @Override
    public void destroy() {

    }
}
