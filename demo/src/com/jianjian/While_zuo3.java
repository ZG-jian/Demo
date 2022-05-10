package com.jianjian;
/**
 * 使用 while 循环 0-130 之间的数字，每行显示 7 个数字。
 */
public class While_zuo3 {
    public static void main(String[] args) {
    int number = 0;
    while(number<=120){
        System.out.print(number+"\t");
        if(number%7==6) {
            System.out.println();
        }
        number++;
    }
    }
}
