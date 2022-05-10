package com.jian.web.filter;

import com.jian.pojo.Funs;
import com.jian.pojo.Users;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class SafeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp =(HttpServletResponse)servletResponse;
        //对静态资源做放行处理
        String uri = req.getRequestURI();
        if (uri.endsWith(".js")||uri.endsWith(".css")||uri.endsWith(".gif")){
            filterChain.doFilter(servletRequest, servletResponse);//放行处理
        }else {//说明访问的不是静态资源
            //对用户登录资源做放行
            if (uri.indexOf("login")!=-1||uri.indexOf("userLogin")!=-1){
                filterChain.doFilter(servletRequest,servletResponse);//放行
        }else {
                HttpSession session = req.getSession();
                Users user = (Users) session.getAttribute("user");
                List<Funs> funs = user.getFuns();
                //就不要在循环里做放行，做一个开关
                boolean flag = false;
                for (Funs f:funs
                     ) {
                    //判断当前访问的URI是否在功能数据中包含
                    if (uri.indexOf(f.getFunurl())!=-1){
                        flag = true;
                        break;
                    }
                }
                //根据开关的值来进行跳转
                if (flag){
                    filterChain.doFilter(servletRequest, servletResponse);
                }else {
                    resp.sendRedirect("roleerror");
                }
            }
        }
    }

    @Override
    public void destroy() {

    }
}
