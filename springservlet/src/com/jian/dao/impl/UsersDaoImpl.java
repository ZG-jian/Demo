package com.jian.dao.impl;

import com.jian.dao.UsersDao;
import org.springframework.stereotype.Repository;

@Repository
public class UsersDaoImpl implements UsersDao {
    @Override
    public void insertUsers() {
        System.out.println("insert into users.....");
    }
}
