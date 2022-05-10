package com.jian.service.impl;

import com.jian.exception.UserNotFoundException;
import com.jian.mapper.UserMapper;
import com.jian.pojo.User;
import com.jian.pojo.UserExample;
import com.jian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User userLogin(User user) {
        //这里要拿教职工号跟密码做数据的查询---多条件查询
        UserExample usersExample = new UserExample();
        UserExample.Criteria criteria = usersExample.createCriteria();
        criteria.andTIdEqualTo(user.gettId());
        criteria.andPasswordEqualTo(user.getPassword());
        List<User> list = this.userMapper.selectByExample(usersExample);
        //对list做判断就知道有没有查到数据了
        if (list == null || list.size()<=0){//说明根据给定的查询条件并没有查到数据----登录异常
            throw  new UserNotFoundException("用户名或密码有误");
        }
        return list.get(0);
    }
}
