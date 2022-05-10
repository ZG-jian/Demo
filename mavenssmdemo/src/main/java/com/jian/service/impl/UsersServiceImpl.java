package com.jian.service.impl;

import com.jian.mapper.UsersMapper;
import com.jian.pojo.Users;
import com.jian.pojo.UsersExample;
import com.jian.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户管理业务层
 */
@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;
    /**
     *     查询所有用户
     * @return
     */
    @Override
    public List<Users> findUsersAll() {
        UsersExample usersExample = new UsersExample();
        return this.usersMapper.selectByExample(usersExample);
    }
}
