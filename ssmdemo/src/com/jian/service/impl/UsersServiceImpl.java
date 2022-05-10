package com.jian.service.impl;

import com.jian.exception.UserNotFoundException;
import com.jian.mapper.UsersMapper;
import com.jian.pojo.Users;
import com.jian.pojo.UsersExample;
import com.jian.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户登录业务层
 */
@Service//注册bean对象
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public Users userLogin(Users users) {
        //这里要那用户名跟密码做数据的查询---多条件查询
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andUsernameEqualTo(users.getUsername());
        criteria.andUserpwdEqualTo(users.getUserpwd());
        List<Users> list = this.usersMapper.selectByExample(usersExample);
        //对list做判断就知道有没有查到数据了
        if (list == null || list.size()<=0){//说明根据给定的查询条件并没有查到数据----登录异常
            throw  new UserNotFoundException("用户名或密码有误");
        }
        return list.get(0);
    }
}
