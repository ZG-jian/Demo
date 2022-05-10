package com.bjsxt.service;

import com.bjsxt.pojo.Admin;

public interface AdminService {

    //用户的登陆
    public Admin  login(String uname, String pwd);
    //获得用户和盐值
    public Admin findPwd(String username);
}
