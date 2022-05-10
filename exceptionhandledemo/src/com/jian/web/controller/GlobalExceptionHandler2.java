package com.jian.web.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

/**
 * 只能做页面的跳转，不能做数据的传递，不能像错误页面传递异常信息什么的
 * 为什么没有用？？？    给全名就可以了，跳转也不用给扩展名
 */
//@Configuration
public class GlobalExceptionHandler2 {

    @Bean
    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver(){
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();
        properties.put("java.lang.NullPointerException","error");
        properties.put("java.lang.ArithmeticException","error2");
        resolver.setExceptionMappings(properties);
        return resolver;
    }
}
