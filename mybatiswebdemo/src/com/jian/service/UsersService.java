package com.jian.service;

import com.github.pagehelper.PageInfo;
import com.jian.pojo.Users;

public interface UsersService {
    void addUsers(Users users);
    PageInfo<Users> findUSers(int page,Users users);
}
