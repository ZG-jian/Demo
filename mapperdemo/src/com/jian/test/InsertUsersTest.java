package com.jian.test;

import com.jian.pojo.Users;
import com.jian.service.UsersService;
import com.jian.service.impl.UsersServiceImpl;

/**
 * 基于mapper动态代理的模式完成添加用户操作测试
 */
public class InsertUsersTest {
    public static void main(String[] args) {
        UsersService usersService = new UsersServiceImpl();
        Users users = new Users();
        users.setUsername("xiaohong");
        users.setUsersex("women");
        usersService.addUsers(users);
    }
}
