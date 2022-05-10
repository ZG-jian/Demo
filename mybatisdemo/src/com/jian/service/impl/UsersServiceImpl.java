package com.jian.service.impl;

import com.jian.Utils.MybatisUtils;
import com.jian.dao.UsersDao;
import com.jian.dao.impl.UsersDaoImpl;
import com.jian.pojo.Users;
import org.apache.ibatis.session.SqlSession;
import com.jian.service.UsersService;

import java.util.Map;

public class UsersServiceImpl implements UsersService {
    /**
     * 添加用户
     * @param users
     */
    @Override
    public void addUsers(Users users) {
    //除了调用UsersDao还得做事务控制
        //注意，在这里通过工具类获取到sqlSession然后调用UsersDaoImpl时
        /**
         * 就是从threadLocal里面获取，如果在这里，也就是业务层里又调用了其他Dao的方法
         * 同样的道理，都会从工具类里获取相同的session
         * 这就在业务层里实现统一的事务处理
         */
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UsersDao usersDao = new UsersDaoImpl();
            usersDao.insertUsers(users);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            MybatisUtils.closeSqlSession();
        }
    }

    @Override
    public Users preUpdateUsers(int userid) {
        Users users = null;
        try {
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            UsersDao usersDao = new UsersDaoImpl();
            users = usersDao.selectUsersById2(userid);
        }catch (Exception e){
        e.printStackTrace();
        }finally {
            MybatisUtils.closeSqlSession();
        }
        return users;
    }

    @Override
    public void modifyUsers(Users users) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UsersDao usersDao = new UsersDaoImpl();
            usersDao.updateUsersById(users);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            MybatisUtils.closeSqlSession();
        }
    }

    @Override
    public void dropUsersById(int userid) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UsersDao usersDao = new UsersDaoImpl();
            usersDao.deleteUsersById(userid);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            MybatisUtils.closeSqlSession();
        }
    }

    @Override
    public Map<Integer, Users> findUsersByNameAndSex(String username, String usernsex) {
        Map<Integer,Users> map = null;
        try {
        UsersDao usersDao = new UsersDaoImpl();
        map = usersDao.selectUserByNameAndSex(username,usernsex);
        }catch (Exception e){
        e.printStackTrace();
        }finally {MybatisUtils.closeSqlSession();
        }
        return map;
    }
}
