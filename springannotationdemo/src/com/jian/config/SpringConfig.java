package com.jian.config;

import com.jian.dao.UsersDao;
import com.jian.dao.impl.UsersDaoImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    @Qualifier("suibianDao")//可以起个名称，然后在业务层那注入的时候找
    public UsersDao usersDaoInit(){
        return new UsersDaoImpl();
    }
}
