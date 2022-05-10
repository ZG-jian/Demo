package com.jian.test;

import com.jian.dao.UsersDao;
import com.jian.dao.impl.UsersDaoImpl;
import com.jian.pojo.Users;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        UsersDao usersDao = new UsersDaoImpl();
      /*  List<Users> list = usersDao.selectUsersAll();
        for (Users users:list
             ) {
            System.out.println(users);
        }*/

        Users users = usersDao.selectUsersById(1);
        System.out.println(users);
    }
}
