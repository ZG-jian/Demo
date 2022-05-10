package com.jianjian.homework;

import java.util.Arrays;

public class TestWork {
    public static void main(String[] args) {
        Commodity commodity0 = new Commodity(1,"百战牌鼠标",
                "BZ_001",99.21,0.9);
        Commodity commodity1 = new Commodity(2,"键盘侠玩偶",
                "WO_102",50.66,0.8);
        Commodity commodity2 = new Commodity(3,"实战Java程序设计",
                "BK_001",666.66,0.7);
        Commodity commodity3 = new Commodity(4,"高琪牌西装",
                 "GQ_XF_12",423.65,0.6);
        Commodity commodity4 = new Commodity(5,"大米牌手机",
                "DM_Sj_001",800.99,0.5);

        Commodity[] allCommodity = {commodity0,commodity1,commodity2,commodity3,commodity4};
        show(allCommodity);
        canBy(allCommodity);

        Arrays.sort(allCommodity);

//
//        for (int i = 0; i < allCommodity.length; i++) {
//            System.out.println(allCommodity[i]);
//        }
    }

//方法，遍历（toString()）这个数组，打印表的信息。
    //这里拖久了，不熟悉传参和调用了，不能直接使用main里面的属性
public static void show(Commodity[] a){
    for (int i = 0; i < a.length; i++) {
        System.out.println(a[i]);
    }
}
//创建一个方法：查询最终购买价，大于指定数字的所有商品
static void canBy(Commodity[] a){
    System.out.println("***************");
    for (int i = 0; i < a.length; i++) {
        if(a[i].getPrice() * a[i].getDiscount() <= 5000){
            System.out.println("你买的起"+a[i].getPrice() * a[i].getDiscount()+"的"+a[i].getName());
        }
    }

}


}
