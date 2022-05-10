package com.jian.test;

import com.jian.mapper.UsersMapper;
import com.jian.pojo.Roles;
import com.jian.pojo.Users;
import com.jian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

public class SelectUsersAndRolesTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        Users users = mapper.selectUsersAndRoles(1);
        System.out.println(users);
        Roles roles = users.getRoles();
        System.out.println(roles);
    }
}
