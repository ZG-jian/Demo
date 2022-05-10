package com.jian.test;

import com.jian.mapper.UsersMapper;
import com.jian.pojo.Items;
import com.jian.pojo.Orders;
import com.jian.pojo.Users;
import com.jian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class selectUsersAndOrderAndItemsTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UsersMapper mapper = sqlSession.getMapper(UsersMapper.class);
        Users users = mapper.selectUsersAndOrderAndItems(1);
        System.out.println(users);
        List<Orders> orders = users.getOrders();//order里有item对象，就不能用lamda表达式遍历了
        for (Orders order:orders
             ) {
            System.out.println(order);
            List<Items> items = order.getItems();
            items.forEach(System.out::println);
        }
    }
}
