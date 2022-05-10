package com.jian.service.impl;

import com.jian.service.UsersService;

public class UsersServiceImpl implements UsersService {
    @Override
    public int addUsers() {
        System.out.println("insert into users....");
        return 1;
    }
}
