package com.jian.service.impl;

import com.jian.service.UsersService;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    @Override
    public void addUsers() {
        System.out.println("AddUsers.....");
    }
}
