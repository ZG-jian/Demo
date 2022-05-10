package com.jian.test;

import com.jian.mapper.UsersMapper;
import com.jian.pojo.Users;
import com.jian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * 添加用户
 */
public class InsertUsersTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        Users users = new Users();
        users.setUsername("Kevin");
        users.setUsersex("male");
        //insert是完全插入，要求id都要有值
        mapper.insertSelective(users);
        sqlSession.commit();//不要忘了事务提交

    }
}
