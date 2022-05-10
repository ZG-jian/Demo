package com.jian.test;

import com.jian.mapper.UsersMapper;
import com.jian.pojo.Orders;
import com.jian.pojo.Users;
import com.jian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class selectUsersByIdLazyTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);//获取代理对象
        Users users = mapper.selectUsersByIdLazy(1);
        System.out.println(users);
        List<Orders> list = users.getOrders();
        list.forEach(System.out::println);
//        users.aa();

    }
}
