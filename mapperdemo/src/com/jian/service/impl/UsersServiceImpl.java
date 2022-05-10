package com.jian.service.impl;

import com.jian.mapper.UsersMapper;
import com.jian.pojo.Users;
import com.jian.service.UsersService;
import com.jian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UsersServiceImpl implements UsersService {
    @Override
    public List<Users> findUsersAll() {
        List<Users> list = null;
        try {
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            //要它帮哪个接口生成代理对象，就把哪个接口的class给它
            //getMapper方法的作用是根据给定接口的class对象，生成该接口的接口实现类的代理对象
            UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
            list = mapper.selectUsersAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtils.closeSqlSession();
        }
        return list;
    }

    @Override
    public Users findUsersById(int userid) {
        Users users = null;
        try {
            SqlSession sqlSession = MybatisUtils.getSqlSession();
            UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
            users = mapper.selectUsersById(userid);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MybatisUtils.closeSqlSession();
        }
        return users;
    }

    @Override
    public void addUsers(Users users) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
            int i = mapper.insertUsers(users);
            sqlSession.commit();
        }catch (Exception e){
           e.printStackTrace();
           sqlSession.rollback();
        }finally {
            MybatisUtils.closeSqlSession();
        }
    }

    @Override
    public void addUsersGetKey(Users users) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
           mapper.insertUsersGetKey(users);//方法执行结束users的userid有值了就
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            MybatisUtils.closeSqlSession();
        }
    }

    @Override
    public void addUsersGetKey2(Users users) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try {
            UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
            mapper.insertUsersGetKey2(users);//方法执行结束users的userid有值了就
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            MybatisUtils.closeSqlSession();
        }
    }
}
