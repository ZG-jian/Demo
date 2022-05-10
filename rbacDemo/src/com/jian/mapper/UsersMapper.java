package com.jian.mapper;

import com.jian.pojo.Users;
import org.apache.ibatis.annotations.Param;

public interface UsersMapper {
    Users selectUserByName(@Param("username") String username);

}
