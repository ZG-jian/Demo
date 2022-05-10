package com.bjsxt.controller;

import com.bjsxt.pojo.Admin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


//现在controller就不再做业务处理了，进行异常信息的处理
@Controller
public class AdminController {

    @RequestMapping("findMoreMenus")
    public String findMoreMenus(HttpServletRequest req){
        //获得验证成功以后的admin对象
        Admin admin = (Admin) SecurityUtils.getSubject().getPrincipal();
        req.setAttribute("list",admin.getList());
        return "/success.jsp";


    }

    @RequestMapping("login")
    public String  login(HttpServletRequest req){
    //查看具体的异常信息，获得异常的信息名称
        Object ex = req.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
        if (UnknownAccountException.class.getName().equals(ex)){
            req.setAttribute("msg","用户名错误");
        }else if (IncorrectCredentialsException.class.getName().equals(ex)){
            req.setAttribute("msg","凭证不正确");
        }else {
            req.setAttribute("msg","未知异常");
        }
        return "/error.jsp";
    }



}
