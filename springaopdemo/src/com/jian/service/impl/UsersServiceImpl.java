package com.jian.service.impl;

import com.jian.service.UsersService;

public class UsersServiceImpl implements UsersService {
    @Override
    public void addUsers() {
        System.out.println("addUsers......");
    }

    @Override
    public void updateUsers(String username) {
        System.out.println("UpdateUsers"+ username);
    }
}
