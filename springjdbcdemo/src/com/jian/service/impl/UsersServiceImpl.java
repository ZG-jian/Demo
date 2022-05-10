package com.jian.service.impl;

import com.jian.dao.UsersDao;
import com.jian.pojo.Users;
import com.jian.service.UsersService;

import java.util.List;

public class UsersServiceImpl implements UsersService {
    private UsersDao usersDao;

    public UsersDao getUsersDao() {
        return usersDao;
    }

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    /**
     * 添加用户
     * @param users
     * @return
     */
    @Override
    public int addUsers(Users users) {
        return this.usersDao.insertUsers(users);
    }

    /**
     * 批量添加用户
     * @param users
     * @return
     */
    @Override
    public int[] addUsers(List<Users> users) {
        return this.usersDao.batchInsertUsers(users);
    }

    @Override
    public Users findUsersById(int userid) {
        return this.usersDao.selectUsersById(userid);
    }

    @Override
    public List<Users> findUsersByname(String username) {
        return this.usersDao.selectUsersByName(username);
    }

    @Override
    public List<Users> findUsersByname2(String username) {
        return this.usersDao.selectUsersByName2(username);
    }
}
