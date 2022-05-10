package com.jian.test;

import com.jian.pojo.Users;
import com.jian.service.UsersService;
import com.jian.service.impl.UsersServiceImpl;

public class SelectUsersByITest {
    public static void main(String[] args) {
        UsersService usersService = new UsersServiceImpl();
        Users users = usersService.findUsersById(1);
        System.out.println(users);
    }
}
