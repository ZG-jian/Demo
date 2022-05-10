package com.jian.test;

import com.jian.mapper.UsersMapper;
import com.jian.pojo.Users;
import com.jian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/*
模糊查询测试
 */
public class selectUsersByLikeNameTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        List<Users> list = mapper.selectUsersByLikeName("n");
        list.forEach(System.out::println);
        MybatisUtils.closeSqlSession();
    }
}
