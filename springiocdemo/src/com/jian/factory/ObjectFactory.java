package com.jian.factory;

import com.jian.service.UsersService;
import com.jian.service.impl.UsersServiceImpl;

public class ObjectFactory {
    public static UsersService getInstance(){
        return new UsersServiceImpl();
    }
}
