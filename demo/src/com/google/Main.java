package com.google;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello");
        int number_a=2,number_b=7;
        int sum=sum(number_a,number_b);
        System.out.println("sum = " + sum);
    }
     public static int sum(int number_a,int number_b){
        return number_a+number_b;
     }
}
