package com.jian.factory;

import com.jian.service.UsersService;
import com.jian.service.impl.UsersServiceImpl;

public class DynamicObjectFactory {
    public UsersService getInstance(){
        return new UsersServiceImpl();
    }
}
