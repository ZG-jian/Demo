package com.jian.test;

import com.jian.mapper.UsersMapper;
import com.jian.pojo.Users;
import com.jian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 遍历数组
 */
public class selectUsersByIdUseArrayTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        int[] arr = {1,2};
        List<Users> users = mapper.selectUsersByIdUseArray(arr);
        users.forEach(System.out::println);
    }
}
