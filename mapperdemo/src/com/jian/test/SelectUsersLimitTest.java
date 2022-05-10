package com.jian.test;

import com.jian.mapper.UsersMapper;
import com.jian.pojo.Users;
import com.jian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * SQL语句分页，第一条也是从0开始的
 */
public class SelectUsersLimitTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        //使用前先创建
        List<Users> list = mapper.selectUsersLimit(1,1);
        list.forEach(System.out::println);
        MybatisUtils.closeSqlSession();
    }
}
