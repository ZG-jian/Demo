package com.jian.test;

import com.jian.mapper.UsersMapper;
import com.jian.pojo.Users;
import com.jian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 通过@Parameter完成参数的绑定测试
 */
public class SelectUsersByAnn {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        List<Users> list = mapper.selectUsersAnn("jian", "male");
        list.forEach(System.out::println);
        MybatisUtils.closeSqlSession();
    }
}
