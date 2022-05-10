package com.jianjian.array;

public class ArrayCopy {
    public static void main(String[] args) {
        String[] bigChang = {"华为","腾讯","网易","阿里"};
        String[] bigChangBak = new String[5];
        System.arraycopy(bigChang,0,bigChangBak,0,bigChang.length);
        for (int i = 0; i <bigChangBak.length ; i++) {
            System.out.print(bigChangBak[i]+"\t");

        }
    }
}
