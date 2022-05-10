package com.jian.service;

import com.jian.pojo.Orders;
import com.jian.pojo.Users;

public interface UsersService {
    void addUsersAndOrders(Users users, Orders orders) throws Exception;
}
