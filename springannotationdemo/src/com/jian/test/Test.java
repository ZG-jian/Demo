package com.jian.test;

import com.jian.service.UsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        String[] arr = applicationContext.getBeanDefinitionNames();
        for (String str:arr
        ) {
            System.out.println(str);
        }
        UsersService usersServiceImpl = (UsersService) applicationContext.getBean("suibian");
//        System.out.println(usersServiceImpl);
        usersServiceImpl.addUsers();
    }
}
