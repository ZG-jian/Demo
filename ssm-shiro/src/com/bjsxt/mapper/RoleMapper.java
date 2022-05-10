package com.bjsxt.mapper;

import com.bjsxt.pojo.Role;

public interface RoleMapper {
    //查询角色的名称
    public Role selectOne(int rid);
}
