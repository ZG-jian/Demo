package com.jian.service.impl;

import com.jian.dao.UsersDao;
import com.jian.dao.impl.UsersDaoImpl;
import com.jian.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 如果在添加注册Bean对象的注解中并未指定Bean对象的ID
 * 那么springIOC容器会使用该类的名称并且将首字母转换小写作为bean对象的id
 * 注解只有一个value属性可以指定该bean对象的id
 * Service注解跟Component注解是一样的，这个注解是被Component修饰的
 */
//@Component("suibian")
    @Service("suibian")
public class UsersServiceImpl implements UsersService {
        @Value("${jdbc.name}")
        private String name;

        @Autowired
        @Qualifier("suibianDao")
    private UsersDao usersDao;

/*    @Autowired
    public void suibian(UsersDao usersDao){
        this.usersDao = usersDao;
    }*/



    @Override
    public void addUsers() {
        System.out.println("UsersDao....+"+this.usersDao+"  "+name);

    }
}
