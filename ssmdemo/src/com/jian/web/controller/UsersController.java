package com.jian.web.controller;

import com.jian.pojo.Users;
import com.jian.pojo.UsersExt;
import com.jian.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户管理控制器
 */
@Controller
@RequestMapping("/user")
public class UsersController {
    @Autowired//按照Bean的类型完成自动注入--也就是找到UsersServiceImpl注入进去
    private UsersService usersService;
    /**
     * 用于处理用户登录请求
     */
    @RequestMapping("/userLogin")
    public String userLogin(UsersExt users, HttpSession session, HttpServletRequest request){
        String ip = request.getRemoteAddr();//这个返回的就是ip地址
        users.setIp(ip);
        //注入httpSession？因为用户一旦登录成功，我们需要建立一个客户端和服务端会话状态
        Users user = this.usersService.userLogin(users);
        session.setAttribute("user",user);
        //页面跳转---重定向(跳转首页，要改地址栏)
        return "redirect:/page/index";
        //这里我们就用springMVC的全局异常处理器来处理异常

    }
}
