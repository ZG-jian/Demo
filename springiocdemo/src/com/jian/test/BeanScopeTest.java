package com.jian.test;

import com.jian.service.UsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("------------------");
        UsersService usersService = (UsersService)applicationContext.getBean("usersService");
        UsersService usersService1 = (UsersService)applicationContext.getBean("usersService");
        System.out.println(usersService);
        System.out.println(usersService1);


    }
}
