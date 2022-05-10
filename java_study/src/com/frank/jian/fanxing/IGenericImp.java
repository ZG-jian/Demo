package com.frank.jian.fanxing;
//泛型接口的实现类
public class IGenericImp implements IGeneric<String> {
    @Override
    public String getName(String name) {
        return name;
    }
}
