package com.jian.dao.impl;

import com.jian.dao.UsersDao;

public class UsersDaoMybatisImpl implements UsersDao {
    @Override
    public void insertUsers() {
        System.out.println("Mybatis......insert into");
    }
}
