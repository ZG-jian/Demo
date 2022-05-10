package com.book.five;

public class Test {
    public static void main(String[] args) {
        String str = "123456";
        System.out.println(str.substring(1));//返回移掉某个位置之前的
        System.out.println(str.substring(1, 2));//返回移掉的
        System.out.println(str.concat("6"));//拼接
        System.out.println(str);
    }
}
