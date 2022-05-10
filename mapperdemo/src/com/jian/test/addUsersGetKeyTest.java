package com.jian.test;

import com.jian.pojo.Users;
import com.jian.service.UsersService;
import com.jian.service.impl.UsersServiceImpl;

public class addUsersGetKeyTest {
    public static void main(String[] args) {
        UsersService usersService = new UsersServiceImpl();
        Users users = new Users();
        users.setUsername("J2");
        users.setUsersex("male");
        usersService.addUsersGetKey(users);
        System.out.println(users.getUserid());//插入数据时获取自增主键的值

    }
}
