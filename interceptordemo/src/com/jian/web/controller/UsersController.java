package com.jian.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UsersController {

    @RequestMapping("/getUsers")
    public String getUsers(Model model) {
        model.addAttribute("msg","Hello Jian");
        return "showuser";
    }

}
