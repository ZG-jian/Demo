package com.jian.test;

import com.jian.mapper.UsersMapper;
import com.jian.pojo.Users;
import com.jian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

/**
 * 批量添加测试
 */
public class insertUsersBatchTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        List<Users> list = new ArrayList<>();
        Users users = new Users();
        users.setUsername("Jian1");
        users.setUsersex("male");
        Users users1 = new Users();
        users1.setUsername("Jian2");
        users1.setUsersex("male");
        Users users2 = new Users();
        users2.setUsername("Jian3");
        users2.setUsersex("male");
        list.add(users);
        list.add(users1);
        list.add(users2);
        int flag = mapper.insertUsersBatch(list);
        System.out.println(flag);
        sqlSession.commit();//别忘了事务
        MybatisUtils.closeSqlSession();


    }
}
