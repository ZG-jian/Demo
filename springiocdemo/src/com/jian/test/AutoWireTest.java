package com.jian.test;

import com.jian.service.UsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWireTest {
    public static void main(String[] args) {
        //启动Spring IOC容器，也可以称为启动Spring框架
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UsersService usersService = (UsersService)applicationContext.getBean("usersService");
        usersService.addUsers();
    }
}
