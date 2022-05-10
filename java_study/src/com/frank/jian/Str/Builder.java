package com.frank.jian.Str;

import org.junit.Test;

public class Builder {
    @Test
    public void code(){
        StringBuilder sb = new StringBuilder("不叫简简饱饱");
        sb.append(12138);
        for (int i = 0; i <10 ; i++) {
            sb.append(i);
        }
        System.out.println(sb);
        StringBuilder sb1 = new StringBuilder("不叫简简饱饱");
        sb1.insert(0,"的").insert(0,"帅气");//插入字符串
        System.out.println(sb1);
        sb1.delete(0,3);//删除字符串0-2之前
        System.out.println(sb1);
        System.out.println(sb1.charAt(2));
        System.out.println(sb1.reverse());//逆序

        System.out.println(sb1.reverse());//逆序回来
        sb1.replace(0,2,"就叫");
        System.out.println(sb1);


    }
}
