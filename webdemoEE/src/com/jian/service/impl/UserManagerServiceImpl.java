package com.jian.service.impl;

import com.jian.dao.UserManagerDao;
import com.jian.dao.impl.UserManagerDaoImpl;
import com.jian.pojo.Users;
import com.jian.service.UserManagerService;

import java.util.List;

/**
 * 用户管理业务层
 */
public class UserManagerServiceImpl implements UserManagerService {
    /**
     * 添加用户
     * @param users
     */
    @Override
    public void addUsers(Users users) {
        UserManagerDao userManagerDao = new UserManagerDaoImpl();
        userManagerDao.insertUser(users);
    }

    /**
     * 查询用户
     * @param users
     * @return
     */
    @Override
    public List<Users> findUser(Users users) {
        UserManagerDao userManagerDao = new UserManagerDaoImpl();
        return userManagerDao.selectUserByProperties(users);
    }

    /**
     * 预更新用户的查询
     * @param userid
     * @return
     */
    @Override
    public Users findUserByUserId(int userid) {
        UserManagerDao userManagerDao = new UserManagerDaoImpl();
        return userManagerDao.selectUserByUserId(userid);
    }

    /**
     * 修改用户
     * @param users
     */
    @Override
    public void modifyUser(Users users) {
        UserManagerDao userManagerDao = new UserManagerDaoImpl();
        userManagerDao.updateUserById(users);
    }

    /**
     * 删除用户
     * @param userid
     */
    @Override
    public void dropUser(int userid) {
        UserManagerDao userManagerDao = new UserManagerDaoImpl();
        userManagerDao.deleteUserByUserId(userid);
    }
}
