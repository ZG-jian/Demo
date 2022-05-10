package com.jian.service.impl;

import com.jian.exception.UsersException;
import com.jian.mapper.UsersMapper;
import com.jian.pojo.Users;
import com.jian.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper usersMapper;

    /**
     * 用户登录
     * @param username
     * @param userpwd
     * @return
     */
    @Override
    public Users userLogin(String username, String userpwd) {
        Users users = this.usersMapper.selectUserByName(username);
        if (users==null){
            //说明用户不存在
            throw new UsersException("用户不存在或密码有误");
        }else if (!users.getUserpwd().equals(userpwd)){
        //密码有误
            throw new UsersException("用户不存在或密码有误");
        }
            return users;
    }
}
