package com.jian.test;

import com.jian.mapper.UsersMapper;
import com.jian.pojo.Users;
import com.jian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * 更新用户
 */
public class UpdateUsersTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        Users users = new Users();
        users.setUsername("zhangsanfeng");
        users.setUsersex("male");
        users.setUserid(16);
        mapper.updateByPrimaryKey(users);
        sqlSession.commit();
    }
}
