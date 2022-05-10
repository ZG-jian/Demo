package com.frank.jian.myProblem;

public class asd {
    public static void main(String[] args) {
        int[] aa = {1,2,3};
    asd a = new asd();
    a.show(aa);
    }
    //？？传可变参数
    public void show(int...aa){
        for (int i = 0; i <aa.length ; i++) {
            System.out.println(aa[i]);
        }
    }
    //传数组
    public void show2(int[] aa){
        for (int i = 0; i <aa.length ; i++) {
            System.out.println(aa[i]);
        }
    }
    //可变参数的作用好像是可以传一个或者多个
    //处理有挺多其他方式
    //但是传数组就单纯处理数组？
}
