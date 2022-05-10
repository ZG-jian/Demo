package com.jian.mapper;

import com.jian.pojo.Orders;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrdersMapper {
    @Select("select * from orders where user_id = #{userid}")
    List<Orders> selectOrdersByUserId(int userid);
}
