package com.jian.test;

import com.jian.mapper.UsersMapper;
import com.jian.pojo.Users;
import com.jian.pojo.UsersExample;
import com.jian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 根据用户姓名与性别查询用户
 */
public class SelectUsersByNameAndSexTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        //不是主键查，就要用封装的了
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria =usersExample.createCriteria();
        criteria.andUsernameEqualTo("jian");
        criteria.andUsersexEqualTo("male");//这两个会自动and
        List<Users> list = mapper.selectByExample(usersExample);
        list.forEach(System.out::println);
    }
}
