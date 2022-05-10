package com.sxt.Collection.List;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        while (true){
            int num = (int)(Math.random()*10+1);
            if (!list.contains(num)){
                list.add(num);
            }
            if (list.size()==10){
                break;
            }
        }
        for (Integer i:list
             ) {
            System.out.println(i);

        }
    }
}
