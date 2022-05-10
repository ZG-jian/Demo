package com.jian.service.impl;

import com.jian.mapper.UsersMapper;
import com.jian.pojo.Users;
import com.jian.pojo.UsersExample;
import com.jian.service.UsersService;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UsersServiceImpl2 extends SqlSessionDaoSupport implements UsersService {
    @Override
    public void addUsers(Users users) {

    }

    @Override
    public List<Users> findUsersAll() {
        UsersMapper mapper = this.getSqlSessionTemplate().getMapper(UsersMapper.class);
        UsersExample usersExample = new UsersExample();
        return mapper.selectByExample(usersExample);
    }
}
