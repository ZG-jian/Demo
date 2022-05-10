package com.jian.aspectj.test;

import com.jian.aspectj.service.UsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextAspectj.xml");
        UsersService usersService = (UsersService) applicationContext.getBean("usersService");
        usersService.addUsers("jian");
    }
}
