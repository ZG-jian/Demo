package com.jian.mapper;

import com.jian.pojo.Roles;
import org.apache.ibatis.annotations.Select;

public interface RolesMapper {
    @Select("select * from roles where user_id = #{userid}")
    Roles selectRolesByUserId(int userid);

}
