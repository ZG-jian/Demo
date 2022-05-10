package com.sxt.Collection.List;

import java.util.HashSet;
import java.util.Set;
//假排列现象，因为取模后放位置，实质上没有排列，TreeSet才会排列
public class SetDemo {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
//自带不允许重复
        while (true){
            int num =(int)(Math.random()*10+1);
            set.add(num);
            if (set.size()==10){
            break;
            }
        }
        for (Integer i:set
             ) {
            System.out.println(i);

        }
    }
}
