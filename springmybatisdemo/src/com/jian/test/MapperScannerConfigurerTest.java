package com.jian.test;

import com.jian.pojo.Users;
import com.jian.service.UsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MapperScannerConfigurerTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext2.xml");
        UsersService usersService3 = (UsersService) applicationContext.getBean("usersService3");
        List<Users> usersAll = usersService3.findUsersAll();
        usersAll.forEach(System.out::println);
    }
}
