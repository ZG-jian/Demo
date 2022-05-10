package com.jian.test;

import com.jian.mapper.UsersMapper;
import com.jian.pojo.Users;
import com.jian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class selectUsersByIdUseCollectionTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
/*        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);*/
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        List<Users> users = mapper.selectUsersByIdUseCollection(set);
        users.forEach(System.out::println);
    }
}
