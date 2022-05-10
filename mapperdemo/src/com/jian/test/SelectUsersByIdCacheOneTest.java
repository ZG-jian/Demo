package com.jian.test;

import com.jian.mapper.UsersMapper;
import com.jian.pojo.Users;
import com.jian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class SelectUsersByIdCacheOneTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        Users users = mapper.selectUsersById(1);
        System.out.println(users);
        Users users2 = new Users();
        users2.setUsername("aaaaa");
        users2.setUsersex("male");
        mapper.insertUsers(users2);//随便插入一个数据
        System.out.println("---------------------------");
        Users users1 = mapper.selectUsersById(1);
        System.out.println(users1);

    }
}
