package com.jian.test;

import com.jian.mapper.UsersMapper;
import com.jian.pojo.Users;
import com.jian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 多选一测试，没有就默认otherwise查id=1
 */
public class selectUsersByChooseTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        Users users = new Users();
        users.setUsername("J");
        users.setUsersex("male");
        List<Users> list = mapper.selectUsersByChoose(users);
        list.forEach(System.out::println);
        MybatisUtils.closeSqlSession();
    }
}
