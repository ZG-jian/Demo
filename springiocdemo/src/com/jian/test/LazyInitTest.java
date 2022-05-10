package com.jian.test;

import com.jian.service.UsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LazyInitTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("-------------");
        UsersService usersService = (UsersService) applicationContext.getBean("usersService");

    }
}
