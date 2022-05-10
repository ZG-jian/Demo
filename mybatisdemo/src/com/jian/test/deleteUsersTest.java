package com.jian.test;

import com.jian.service.UsersService;
import com.jian.service.impl.UsersServiceImpl;

public class deleteUsersTest {
    public static void main(String[] args) {
        UsersService usersService = new UsersServiceImpl();
        usersService.dropUsersById(3);
    }
}
