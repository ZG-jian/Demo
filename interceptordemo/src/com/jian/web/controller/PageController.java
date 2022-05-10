package com.jian.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 完成页面跳转控制器
 */
@Controller
@RequestMapping("/page")
public class PageController {

    @RequestMapping("/{page}/{userid}")//把userid传到model里，还得注入Model对象
    public String showPage(@PathVariable("page") String p, @PathVariable int userid, Model model){//会帮我们转类型
        //方法参数名字和占位符标识名相同就不用动   这里是不相同{page}与p
        // @PathVariable String page    只有一个value属性，不用写
        //不同就要像这样@PathVariable("page") String p
        model.addAttribute("msg",userid);
        return p;

    }
}
