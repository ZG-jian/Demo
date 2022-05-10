package com.jian.service;

import com.jian.pojo.Users;

import java.util.Map;

public interface UsersService {
    void addUsers(Users users);
    Users preUpdateUsers(int userid);
    void modifyUsers(Users users);
    void dropUsersById(int userid);
    Map<Integer,Users> findUsersByNameAndSex(String username,String usernsex);
}
