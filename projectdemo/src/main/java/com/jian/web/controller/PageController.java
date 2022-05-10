package com.jian.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转控制器
 */
@Controller
public class PageController {

    /**
     * 请求首页
     */
    @RequestMapping("/")
    public String showIndex(){
        return "index";
    }
    /**
     * 处理页面跳转请求
     */
    @RequestMapping("/page/{page}")
    public String showPage(@PathVariable String page){
        return page;
    }
}
