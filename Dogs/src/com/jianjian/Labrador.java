package com.jianjian;

public class Labrador extends Dogs {
    //下面是添加final后报错的
//    @Override
//    public boolean Guide() {
//    //    return super.Guide();
//        return true;
//    }
    @Override
    public void braking() {
//        super.braking();
        System.out.println("拉布拉多狂吠");
    }
}
