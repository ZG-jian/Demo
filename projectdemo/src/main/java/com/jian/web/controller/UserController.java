package com.jian.web.controller;

import com.jian.pojo.User;
import com.jian.service.UserService;
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
public class UserController {
    @Autowired
    private UserService userService;//注入业务层对象

    /**
     * 处理用户登录请求的方法
     */
    @RequestMapping("/userLogin")
    public String userLogin(User user, HttpSession session, HttpServletRequest httpServletRequest){
        //Session用来用户登录成功后，建立一个会话状态
        User userSession = this.userService.userLogin(user);
        session.setAttribute("user",userSession);
        return "redirect:/page/index";//重定向页面跳转

    }
}
