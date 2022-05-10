package com.jian.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page, @RequestHeader("Accept-Language") String language, @CookieValue("JSESSIONID") String value){
        System.out.println(language);
        System.out.println(value);
        return page;
    }
}
