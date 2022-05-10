package com.jian.mapper;

import com.jian.pojo.Users;

import java.util.List;

public interface UsersMapper {
    List<Users> selectUsersAll();
    Users selectUsersAndRoles(int userid);
    Users selectUsersAndOrders(int userid);
    Users selectUsersAndOrderAndItems(int userid);
    Users selectUsersByIdLazy(int userid);
}
