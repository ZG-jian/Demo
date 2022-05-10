package com.jian.web.controller;

import com.jian.pojo.Users;
import com.jian.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 处理用户操作控制器
 */
@Controller
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UsersService usersService;

    /**
     * 处理查询用户请求
     */
    @RequestMapping("/findUsersAll")
    public String findUsersAll(Model model){
        List<Users> usersAll = this.usersService.findUsersAll();
        model.addAttribute("list",usersAll);
        return "showUsers";
    }
}
