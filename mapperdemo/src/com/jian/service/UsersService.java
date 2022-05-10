package com.jian.service;

import com.jian.pojo.Users;

import java.util.List;

public interface UsersService {
    List<Users> findUsersAll();
    Users findUsersById(int userid);
    void addUsers(Users users);
    void addUsersGetKey(Users users);
    void addUsersGetKey2(Users users);

}
