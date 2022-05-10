package com.jian.test;

import com.jian.pojo.Users;
import com.jian.service.UsersService;
import com.jian.service.impl.UsersServiceImpl;

public class UpdateUsersTest {
    public static void main(String[] args) {
        UsersService usersService = new UsersServiceImpl();
        Users users = usersService.preUpdateUsers(2);
        System.out.println(users);

        //修改
        users.setUsername("FUCK");
        users.setUsersex("male");
        usersService.modifyUsers(users);
    }
}
