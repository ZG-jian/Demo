package com.jian.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UsersController {

    @RequestMapping("/getUsers")
    public String getUsers() {
        String str = null;
        str.length();
//        int flag = 1/0;
    /*    int[] arr  = new int[1];
        arr[2] = 8;*/
        return "showuser";
    }

}
