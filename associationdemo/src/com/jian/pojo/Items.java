package com.jian.pojo;

/**
 * 我们现在的需求是根据订单查包含哪些商品,那就在order里关联item
 */
public class Items {
    private int itemid;
    private String itemname;

    @Override
    public String toString() {
        return "Items{" +
                "itemid=" + itemid +
                ", itemname='" + itemname + '\'' +
                ", itemprice=" + itemprice +
                '}';
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public double getItemprice() {
        return itemprice;
    }

    public void setItemprice(double itemprice) {
        this.itemprice = itemprice;
    }

    private double itemprice;
}
