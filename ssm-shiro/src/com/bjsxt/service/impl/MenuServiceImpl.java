package com.bjsxt.service.impl;

import com.bjsxt.mapper.MenuMapper;
import com.bjsxt.pojo.Menu;
import com.bjsxt.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuMapper menuMapper;
    @Override
    public List<Menu> findMoreMenu(int rid) {
        //指定角色的下一级菜单
        List<Menu> list = menuMapper.selectMore(rid,0);
        for (Menu menu:list
             ) {
            //以及菜单的mmid
            Integer mmid = menu.getMmid();
            //指定下一级菜单下对应的子菜单
            List<Menu> list2 = menuMapper.selectMore(rid,mmid);
            //把二级菜单保存到指定的一级菜单对象中
            menu.setList(list2);
        }
        return list;
    }
}
