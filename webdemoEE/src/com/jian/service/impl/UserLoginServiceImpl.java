package com.jian.service.impl;

import com.jian.dao.UsersLoginDao;
import com.jian.dao.impl.UserLoginDaoImpl;
import com.jian.exception.UserNotFoundException;
import com.jian.pojo.Users;
import com.jian.service.UserLoginService;

/**
 * 用户登录业务
 */
public class UserLoginServiceImpl implements UserLoginService {
    /**
     * 用户的登录
     * @param username
     * @param userpwd
     * @return
     */
    @Override
    public Users userLogin(String username, String userpwd) {
        UsersLoginDao usersLoginDao = new UserLoginDaoImpl();
        Users users = usersLoginDao.selectUsersByUserNameAndUserPwd(username, userpwd);
        //直接判断返回的user是不是空  ==空说明用户没有查到
        if (users==null){
            //使用自定义异常的方式通知servlet
            throw new UserNotFoundException("用户名或密码有误");
            //学了自定义异常就要用起来，解决层与层之间的耦合
        }
        return users;
    }
}
