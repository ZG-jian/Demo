package com.jian.aspectj.service.impl;

import com.jian.aspectj.service.UsersService;

public class UsersServiceImpl implements UsersService {
    @Override
    public void addUsers(String username) {
        System.out.println("AddUsers..."+username);
    }
}
