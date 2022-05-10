package com.jian.main;

import com.jian.mapper.UserMapper;
import com.jian.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        InputStream is = Resources.getResourceAsStream("Mybatis-config.xml");
        //获取sqlSession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取mapper代理
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //查询数据
        List<User> list = userMapper.selectAll();
        list.forEach(System.out::println);
    }
}
