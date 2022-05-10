package com.jian.test;

import com.jian.mapper.UsersMapper;
import com.jian.pojo.Users;
import com.jian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 这里就不创建业务层直接操作了
 */
public class SelectUsersOrderParam {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        List<Users> list = mapper.selectUsersOrderParam("jian", "male");
        list.forEach(System.out::println);
        MybatisUtils.closeSqlSession();
    }
}
