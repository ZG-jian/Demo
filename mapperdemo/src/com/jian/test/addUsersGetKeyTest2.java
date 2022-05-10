package com.jian.test;

import com.jian.pojo.Users;
import com.jian.service.UsersService;
import com.jian.service.impl.UsersServiceImpl;

public class addUsersGetKeyTest2 {
    public static void main(String[] args) {
        UsersService usersService = new UsersServiceImpl();
        Users users = new Users();
        users.setUsername("J333");
        users.setUsersex("male");
        usersService.addUsersGetKey(users);
        System.out.println(users.getUserid());
    }
}
