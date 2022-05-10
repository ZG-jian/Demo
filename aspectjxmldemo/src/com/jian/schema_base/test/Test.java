package com.jian.schema_base.test;

import com.jian.schema_base.service.BaseUsersService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContextBased.xml");
        BaseUsersService baseUsersService = (BaseUsersService) applicationContext.getBean("baseUsersService");
        baseUsersService.addUsers("Jian");
    }
}
