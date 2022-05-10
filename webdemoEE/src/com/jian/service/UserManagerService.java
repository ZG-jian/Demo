package com.jian.service;

import com.jian.pojo.Users;

import java.util.List;

public interface UserManagerService {
    void addUsers(Users users);//业务层器名要贴近业务
    List<Users>  findUser(Users users);
    Users findUserByUserId(int userid);
    void modifyUser(Users users);
    void dropUser(int userid);
}
