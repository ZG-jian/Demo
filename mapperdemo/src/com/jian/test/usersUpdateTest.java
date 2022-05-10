package com.jian.test;

import com.jian.mapper.UsersMapper;
import com.jian.pojo.Users;
import com.jian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * 选择更新测试
 */
public class usersUpdateTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        Users users = new Users();
        //更新  7  J2 male 为 JCool
        users.setUsername("JCool");
        users.setUsersex("MALE");
        users.setUserid(7);
        mapper.usersUpdate(users);
        sqlSession.commit();
        MybatisUtils.closeSqlSession();
    }
}
