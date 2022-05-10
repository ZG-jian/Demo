package com.jian.pojo;

import java.util.List;

/**
 * 我们需求是通过用户查询order，那就在users对象里定义关联关系
 */
public class Orders {
    private int orderid;
    private Double orderprice;
    private List<Items> items;

    public List<Items> getItems() {
        return items;
    }

    public void setItems(List<Items> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderid=" + orderid +
                ", orderprice=" + orderprice +
                '}';
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public Double getOrderprice() {
        return orderprice;
    }

    public void setOrderprice(Double orderprice) {
        this.orderprice = orderprice;
    }
}
