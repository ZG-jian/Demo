package com.jianjian;
/**
 * 打印0-120 之间的数字，打印出能被 5 整除的数字。
 */
public class While_zuo2 {
    public static void main(String[] args) {
    int number = 0;
    while (number<=120)
    {
        if(number%5==0)
        {
            System.out.println(number);
        }
        number++;
    }
    }
}
