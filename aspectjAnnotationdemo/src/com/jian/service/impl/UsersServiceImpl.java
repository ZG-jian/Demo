package com.jian.service.impl;

import com.jian.service.UsersService;

public class UsersServiceImpl implements UsersService {
    @Override
    public void addUsers(String username) {
        System.out.println("AddUsers..."+username);
    }
}
