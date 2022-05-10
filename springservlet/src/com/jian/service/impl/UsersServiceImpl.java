package com.jian.service.impl;

import com.jian.dao.UsersDao;
import com.jian.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersDao usersDao;
    @Override
    public void addUsers() {
        this.usersDao.insertUsers();
    }
}
