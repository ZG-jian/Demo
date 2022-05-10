package com.jian.test;

import com.jian.pojo.Users;
import com.jian.service.UsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class FindUsersByName2Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UsersService usersService = (UsersService) applicationContext.getBean("usersService");
        List<Users> list = usersService.findUsersByname2("zhangsan");
        list.forEach(System.out::println);
    }
}
