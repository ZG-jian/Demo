package com.bjsxt.service.impl;

import com.bjsxt.mapper.AdminMapper;
import com.bjsxt.mapper.RoleMapper;
import com.bjsxt.pojo.Admin;
import com.bjsxt.pojo.Menu;
import com.bjsxt.service.AdminService;
import com.bjsxt.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("admins")
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper  adminMapper;

@Autowired
    MenuService menuService;

@Autowired
    RoleMapper roleMapper;

    @Override
    public Admin login(String uname, String pwd) {
        return adminMapper.selectOne(uname, pwd);
    }

    @Override
    public Admin findPwd(String username) {
        Admin admin = adminMapper.selectPwd(username);
        //判断丢给shiro去做了，在这就不用去判断admin是否为空
        List<Menu> list = menuService.findMoreMenu(admin.getRid());
        //把菜单保存到指定的admin对象中
        admin.setList(list);
        //把用户的身份保存到admin中
        admin.setRole(roleMapper.selectOne(admin.getRid()));

        //那这样返回的admin就不仅仅包含用户的菜单，还包含了权限
        return admin;
    }
}
