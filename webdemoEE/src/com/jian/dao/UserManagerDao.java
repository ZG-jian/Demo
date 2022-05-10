package com.jian.dao;

import com.jian.pojo.Users;

import java.util.List;

public interface UserManagerDao {
    void insertUser(Users users);
    List<Users> selectUserByProperties(Users users);
    Users selectUserByUserId(int userid);
    void updateUserById(Users users);
    void deleteUserByUserId(int userid);
}
