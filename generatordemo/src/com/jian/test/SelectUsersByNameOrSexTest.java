package com.jian.test;

import com.jian.mapper.UsersMapper;
import com.jian.pojo.Users;
import com.jian.pojo.UsersExample;
import com.jian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * 根据用户姓名或性别查询
 */
public class SelectUsersByNameOrSexTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria =usersExample.createCriteria();
        criteria.andUsernameEqualTo("jian");
        //在同一个criteria中的条件它就是并且的关系，或者就要创建多个criteria
        UsersExample.Criteria criteria1 =usersExample.createCriteria();
        criteria1.andUsersexEqualTo("male");
        usersExample.or(criteria1);//放进去，这样就是或者的关系了
        List<Users> list = mapper.selectByExample(usersExample);
        list.forEach(System.out::println);
    }
}
