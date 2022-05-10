package com.jian.test;

import com.jian.mapper.UsersMapper;
import com.jian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

public class selectUsersCountTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        Map<String,String> map = new HashMap<>();
        map.put("username","J");
        map.put("usersex","male");
        int i = mapper.selectUsersCount(map);//返回计数结果
        System.out.println(i);
        MybatisUtils.closeSqlSession();

    }
}
