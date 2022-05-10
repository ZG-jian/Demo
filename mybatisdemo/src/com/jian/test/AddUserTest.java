package com.jian.test;

import com.jian.pojo.Users;
import com.jian.service.UsersService;
import com.jian.service.impl.UsersServiceImpl;

public class AddUserTest {
    public static void main(String[] args) {
        UsersService usersService = new UsersServiceImpl();
        Users users = new Users();
        users.setUsername("zhangsan");
        users.setUsersex("male");
        usersService.addUsers(users);
    }
}
