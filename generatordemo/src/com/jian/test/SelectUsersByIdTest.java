package com.jian.test;

import com.jian.mapper.UsersMapper;
import com.jian.pojo.Users;
import com.jian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * 根据用户ID查询用户案例，完全使用Mybatis的工具所生成代码实现
 */
public class SelectUsersByIdTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        Users users = mapper.selectByPrimaryKey(1);
        System.out.println(users);

    }
}
