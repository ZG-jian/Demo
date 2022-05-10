package com.jian.dao;

import com.jian.pojo.Orders;
import com.jian.pojo.Users;

public interface UsersDao {
    void insertUsers(Users users);
    void insertOrders(Orders orders);
}
