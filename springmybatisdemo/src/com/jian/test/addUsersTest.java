package com.jian.test;

import com.jian.pojo.Users;
import com.jian.service.UsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class addUsersTest {
    public static void main(String[] args) {
        //配置了mybatis在spring的配置文件中，启动spring就启动mubatis
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UsersService usersService = (UsersService) applicationContext.getBean("usersService");
        Users users = new Users();
        users.setUsername("suibian333");
        users.setUsersex("male");
        usersService.addUsers(users);
    }
}
