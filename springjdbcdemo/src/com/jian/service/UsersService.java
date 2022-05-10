package com.jian.service;

import com.jian.pojo.Users;

import java.util.List;

public interface UsersService {
    int addUsers(Users users);
    int[] addUsers(List<Users> users);
    Users findUsersById(int userid);
    List<Users> findUsersByname(String username);
    List<Users> findUsersByname2(String username);
}
