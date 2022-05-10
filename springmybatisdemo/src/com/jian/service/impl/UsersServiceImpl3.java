package com.jian.service.impl;

import com.jian.mapper.UsersMapper;
import com.jian.pojo.Users;
import com.jian.pojo.UsersExample;
import com.jian.service.UsersService;

import java.util.List;

public class UsersServiceImpl3 implements UsersService {
    private UsersMapper usersMapper;

    public void setUsersMapper(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @Override
    public void addUsers(Users users) {

    }

    @Override
    public List<Users> findUsersAll() {
        UsersExample usersExample = new UsersExample();
        return this.usersMapper.selectByExample(usersExample);
    }
}
