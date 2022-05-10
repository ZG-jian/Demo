package com.jian.test;

import com.jian.mapper.UsersMapper;
import com.jian.pojo.Users;
import com.jian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class updateUsersTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        Users users = new Users();
        users.setUsername("aaa");
        users.setUsersex("fmale");
        users.setUserid(15);
        int flag = mapper.updateUsers(users);
        sqlSession.commit();
        System.out.println(flag);

    }
}
