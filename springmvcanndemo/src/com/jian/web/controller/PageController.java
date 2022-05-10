package com.jian.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/page")
public class PageController {
    @RequestMapping("/login")
    public String showLogin(HttpServletRequest request, Map<String,String> map, Model model,HttpSession session){
//        ServletContext servletContext = request.getSession().getServletContext();第一钟方式
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("msg","Hello JCool");
        return "login";
    }

    @RequestMapping("/login2")
    public void showLogin2(HttpServletRequest request, HttpServletResponse response)throws Exception{
        request.setAttribute("msg","JianJian");
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
    }

    @RequestMapping("/login3")
    public String showLogin3(Model model){
        model.addAttribute("msg","JJJ");
        return "forward:/WEB-INF/jsp/login.jsp";//自己指定视图所在位置和已经扩展名
    }

    @RequestMapping("/login4")
    public String showLogin4(Model model){
        model.addAttribute("msg","Jian888");
        return "login";
    }

    @RequestMapping("/redirectLogin")
    public String redirectLogin(){
        return "redirect:/page/login4";
    }
}
