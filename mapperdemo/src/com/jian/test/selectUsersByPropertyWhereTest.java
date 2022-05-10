package com.jian.test;

import com.jian.mapper.UsersMapper;
import com.jian.pojo.Users;
import com.jian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class selectUsersByPropertyWhereTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        Users users = new Users();
        users.setUsername("J");//J有两条，查一手
//        users.setUserid(6);//查6的J
        List<Users> list = mapper.selectUsersByPropertyWhere(users); //不给任何条件，全查
        list.forEach(System.out::println);
        MybatisUtils.closeSqlSession();
    }
}
