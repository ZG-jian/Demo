package com.jian.web.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class GlobalExceptionHandler3 implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
       if(e instanceof NullPointerException){
        modelAndView.setViewName("error");
       }
       if (e instanceof ArithmeticException){
           modelAndView.setViewName("error2");
       }
       modelAndView.addObject("msg",e);
        return modelAndView;//这样就实现了根据不同的异常类型跳转到不同的异常页面
    }
}
