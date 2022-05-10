package com.jian.test;

import com.jian.mapper.UsersMapper;
import com.jian.pojo.Users;
import com.jian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 没有创建业务层的通过POJO传参测试
 */
public class SelectUsersPOJOParam {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        Users users = new Users();
        users.setUsername("jian");
        users.setUsersex("male");
        List<Users> list = mapper.selectUsersPOJOParam(users);
        list.forEach(System.out::println);
        MybatisUtils.closeSqlSession();
    }
}
