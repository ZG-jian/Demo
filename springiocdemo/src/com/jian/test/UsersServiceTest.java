package com.jian.test;

import com.jian.service.UsersService;
import com.jian.service.impl.UsersServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UsersServiceTest {
    public static void main(String[] args) {
/*        UsersService usersService = new UsersServiceImpl();
        usersService.addUsers();*/
        //1.先启动spring IOC容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从IOC容器中获取对象  给唯一ID
/*        UsersService usersService = (UsersService) applicationContext.getBean("name1");
        usersService.addUsers();*/
/*
        //通过类型获取bean对象
        UsersService usersService = applicationContext.getBean(UsersServiceImpl.class);
        usersService.addUsers();*/


        //根据id或name区别获取指定的对象方式一
/*        UsersService usersService = applicationContext.getBean("usersService",UsersServiceImpl.class);
        usersService.addUsers();*/

        /*方式二*/
        //获取Spring IOC容器中所有Bean对象的ID
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String name:beanDefinitionNames
             ) {
            System.out.println(name);
        }
        UsersService usersService1 = applicationContext.getBean(beanDefinitionNames[0],UsersServiceImpl.class);
        usersService1.addUsers();
    }
}
