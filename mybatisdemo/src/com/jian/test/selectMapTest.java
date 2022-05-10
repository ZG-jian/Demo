package com.jian.test;

import com.jian.pojo.Users;
import com.jian.service.UsersService;
import com.jian.service.impl.UsersServiceImpl;

import java.util.Map;
import java.util.Set;

public class selectMapTest {
    public static void main(String[] args) {
        UsersService usersService = new UsersServiceImpl();
        Map<Integer, Users> map = usersService.findUsersByNameAndSex("jian", "male");
        Set<Integer> integers = map.keySet();
        for (Integer key:integers
             ) {
            Users users = map.get(key);
            System.out.println(key);
            System.out.println(users.getUserid()+"\t"+users.getUsername()+"\t"+users.getUsersex());


        }

    }
}
