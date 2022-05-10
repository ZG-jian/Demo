package com.jian.test;

import com.jian.pojo.Users;
import com.jian.service.UsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class BatchAddUsersTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UsersService usersService = (UsersService) applicationContext.getBean("usersService");
        Users users = new Users();
        users.setUsername("jianBatchAdd1");
        users.setUsersex("male");
        Users users1 = new Users();
        users1.setUsername("jianBatchAdd2");
        users1.setUsersex("male");
        List<Users> list = new ArrayList<>();
        list.add(users);
        list.add(users1);
        usersService.addUsers(list);
    }
}
