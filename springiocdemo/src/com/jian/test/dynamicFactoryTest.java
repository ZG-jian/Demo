package com.jian.test;

import com.jian.service.UsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class dynamicFactoryTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UsersService usersService3 = (UsersService) applicationContext.getBean("usersService3");
        usersService3.addUsers();
    }
}
