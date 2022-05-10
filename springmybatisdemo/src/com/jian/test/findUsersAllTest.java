package com.jian.test;

import com.jian.pojo.Users;
import com.jian.service.UsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class findUsersAllTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UsersService usersService = (UsersService) applicationContext.getBean("usersService");
        List<Users> usersAll = usersService.findUsersAll();
        usersAll.forEach(System.out::println);
    }
}
