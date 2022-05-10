package com.jian.web.controller;

import com.jian.exception.UsersException;
import com.jian.pojo.Funs;
import com.jian.pojo.Users;
import com.jian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/userLogin")
    public String UserLogin(Users users, Model model, HttpServletRequest request){//直接注入一个Users对象
        //然后还要注入一个Model，要把登录失败抛出的异常的信息带回去
        //要是用户名或者密码不对，就会抛出异常，
        // 我们要在controller里把他catch掉，登录失败给他跳回到login.jsp让他重新登录
        try {
            Users u = this.userService.userLogin(users.getUsername(),users.getUserpwd());
            List<Funs> funs = u.getFuns();
            for (Funs f:funs
                 ) {
                System.out.println(f.getFunname()+" "+f.getFunurl());
            }
            //建立会话
            HttpSession session = request.getSession();
            session.setAttribute("user",u);
            //对于这种地址栏的挑战必须改变url，也就是使用重定向方式跳转
        }catch (UsersException e){
            e.printStackTrace();
            model.addAttribute("msg",e.getMessage());
            return "login";//还必须得用请求转发，但是springMVC默认就是用请求转发
        }
    return "index";
    }
}
