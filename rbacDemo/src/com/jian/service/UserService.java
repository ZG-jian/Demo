package com.jian.service;

import com.jian.pojo.Users;

public interface UserService {
    Users userLogin(String username,String userpwd);
}
