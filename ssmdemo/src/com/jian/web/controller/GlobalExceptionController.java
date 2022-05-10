package com.jian.web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理器
 */
@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler({com.jian.exception.UserNotFoundException.class})
    public String userNotFoundExceptionHandler(Exception e, Model model){
        //跳回Login
        model.addAttribute("msg",e.getMessage());//这样就取到我们再异常中给定的信息了
        return "login";
    }

    //除了userNotFoundException，其他所有异常都统一跳到一个错误页面
    @ExceptionHandler({java.lang.Exception.class})
    public String exceptionHandler(Exception e){
        return "redirect:/page/error";//用重定向不走视图解析器了
    }
}
