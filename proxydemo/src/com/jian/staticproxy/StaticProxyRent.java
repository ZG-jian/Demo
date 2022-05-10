package com.jian.staticproxy;

public class StaticProxyRent implements Rent {
    private Rent rent;

    public StaticProxyRent(Rent rent) {
        this.rent = rent;
    }

    @Override
    public void renting() {
        System.out.println("向房客出租房屋");
        this.rent.renting();
        System.out.println("完成售后服务");
    }
}
