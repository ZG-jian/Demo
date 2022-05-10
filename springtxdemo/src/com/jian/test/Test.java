package com.jian.test;

import com.jian.pojo.Orders;
import com.jian.pojo.Users;
import com.jian.service.UsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) throws Exception{
        //如果就想引入一个配置文件，那就要在一个配置文件中导入，不想就给数组
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext( new String[]{"applicationContext-service.xml","applicationContext-tx.xml"});
        UsersService usersService = (UsersService) applicationContext.getBean("usersService");
        Users users = new Users();
        users.setUsername("suibain456");
        users.setUsersex("male");
        Orders orders = new Orders();
        orders.setOrderprice(2800);
        usersService.addUsersAndOrders(users,orders);
    }
}
