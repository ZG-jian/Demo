package com.jian.interceptor;

import com.jian.pojo.Users;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 判断用户是否登录
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*如何判断用户是否登录？获取httpSession对象，因为用户一旦登录成功了，我们把登录的对象放到了
        Session当中，那就可以通过获取Session，看HttpSession当中是否含有已登录的用户，没有就需要让它登录
        */
        HttpSession session = request.getSession();
        Users user = (Users)session.getAttribute("user");
        if (user==null||user.getUsername().length()<=0){
             //判断进来说明用户没登陆
            response.sendRedirect("page/login");
            return false;
        }
        //没有走上面判断说明用户登录过了，那就继续放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
