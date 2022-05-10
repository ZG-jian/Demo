package com.bjsxt.mapper;

import com.bjsxt.pojo.Menu;

import java.util.List;

public interface MenuMapper {
    public List<Menu> selectMore(int rid,int pid);
}
