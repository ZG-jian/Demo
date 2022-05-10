package com.jian.dao;

import com.jian.pojo.Users;

public interface UsersLoginDao {
    public Users selectUsersByUserNameAndUserPwd(String username,String userpwd);
}
