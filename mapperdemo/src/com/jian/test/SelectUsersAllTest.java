package com.jian.test;

import com.jian.pojo.Users;
import com.jian.service.UsersService;
import com.jian.service.impl.UsersServiceImpl;

import java.util.List;

/**
 * 现在已经能够通过mybatis动态代理的方式查询全部数据了
 */
public class SelectUsersAllTest {
    public static void main(String[] args) {
        UsersService usersService =  new UsersServiceImpl();
        List<Users> list = usersService.findUsersAll();
//        list.forEach(e -> System.out.println(e));
                //  还有一种写法
          list.forEach(System.out::println);

      /*相当于
        for (Users e:list
             ) {
            System.out.println(e);

        }*/
      /*
      MapperRegistry 不知道类型接口
      这个问题就是之前报错时候改了全局配置中引入的方式，那时候报没有数据源才改的
      有数据源之后忘了改回
       */

    }
}
