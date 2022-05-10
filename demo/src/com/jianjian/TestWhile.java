package com.jianjian;

public class TestWhile {
    public static void main(String[] args) {
        int a=1,sum = 0;
        int sumO =0;
        int sumJ =0;
        while (a<=100){
            sum+=a;
            if((a%2)==0) {
                sumO += a;
            }
            else
            {
                sumJ += a;
            }
            a++;
        }
        System.out.println(sum);
        System.out.println("奇数="+sumJ+"偶数="+sumO);
    }
}
