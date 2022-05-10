package com.jian.service.impl;

import com.jian.dao.UsersDao;
import com.jian.pojo.Orders;
import com.jian.pojo.Users;
import com.jian.service.UsersService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class UsersServiceImpl implements UsersService {
    private UsersDao usersDao;

    public UsersDao getUsersDao() {
        return usersDao;
    }

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    /**
     * 添加用户与订单
     * @param users
     * @param orders
     */
    @Override
    public void addUsersAndOrders(Users users, Orders orders) throws Exception{
            this.usersDao.insertOrders(orders);
            this.usersDao.insertUsers(users);
    }
}
