package com.jian;

public class lemonChange {
    public static void main(String[] args) {
        System.out.println(change(new int[]{5,5,10}));
    }
    public static boolean change(int[] bills){
        int five = 0,ten=0;
        for (int bill:bills
             ) {
            if (bill==5){
                five++;
            } else if (bill==10){
                if (five==0){
                    return false;
                }
                five--;
                ten++;
            }else {//20,局部最优解，找5和10
                if (five>0&&ten>0){
                    five--;
                    ten--;
                }else if (five>=3){
                    five -=3;
                }else {
                    return false;//拿不出两种方案找钱就返回false
                }
            }
        }
        return true;
    }
}
