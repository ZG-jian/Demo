package com.jian.service;

import com.jian.pojo.Users;

public interface UserLoginService {
     Users userLogin(String username,String userpwd);//在业务层的方法命名，更多看它的完成什么样的一个业务
}
