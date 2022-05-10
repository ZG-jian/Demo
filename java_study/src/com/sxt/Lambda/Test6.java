package com.sxt.Lambda;

/**
 * lambda闭包问题
 */
public class Test6 {
    public static void main(String[] args) {
       final int num = 100;
        NoReturnNoParam noReturnNoParam = ()-> System.out.println(num);
        noReturnNoParam.method();



    }
}
