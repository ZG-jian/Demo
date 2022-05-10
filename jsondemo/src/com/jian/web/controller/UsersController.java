package com.jian.web.controller;

import com.jian.pojo.Users;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UsersController {

    /**
     * 处理异步请求的方法
     * @param users
     * @param response
     * @throws Exception
     */                                      //一用MediaType.TEXT_PLAIN_VALUE就报错，不理解
    @RequestMapping(value = "/addUsers")//现在异步提交，不能做页面跳转的,响应得用流推回去
    @ResponseBody
    @CrossOrigin(origins ="http://locahost:8080" )//这表示只有你的域名是http://locahost:8080在做跨域请求时才做跨域处理，不是这个域名下的，我都不支持做跨域处理
    //String数组类型没有配origins表示当前处理/addUsers这个请求的方法是可以被任何的域名下的资源所访问的
    public Object addUsers(@RequestBody Users users, HttpServletResponse response) throws Exception{
        System.out.println(users);
        return users;
    }
}
