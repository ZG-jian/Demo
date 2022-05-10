package com.bjsxt.service;

import com.bjsxt.pojo.Menu;

import java.util.List;

public interface MenuService {
    public List<Menu> findMoreMenu(int rid);
}
