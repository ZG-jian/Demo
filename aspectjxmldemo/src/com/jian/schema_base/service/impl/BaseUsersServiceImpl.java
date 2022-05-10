package com.jian.schema_base.service.impl;

import com.jian.schema_base.service.BaseUsersService;

public class BaseUsersServiceImpl implements BaseUsersService {
    @Override
    public void addUsers(String username) {
        System.out.println("AddUsers....   "+username);
    }
}
