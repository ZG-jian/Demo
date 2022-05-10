package com.jian.test;

import com.jian.mapper.UsersMapper;
import com.jian.pojo.Users;
import com.jian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * 二级缓存的测试，创建两个sqlSession完成同一个查询，第一个执行完关闭掉
 */
public class SelectUsersByIdCacheTwoTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        Users users = mapper.selectUsersById(1);
        System.out.println(users);
        MybatisUtils.closeSqlSession();
        System.out.println("--------------------");
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();
        UsersMapper mapper1 = sqlSession1.getMapper(UsersMapper.class);
        Users users1 = mapper1.selectUsersById(1);
        System.out.println(users1);

    }
}
