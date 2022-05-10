package com.sxt.Lambda;

public class Test2 {
    public static void main(String[] args) {
        //静态方法作为函数式接口抽象方法的实现方法
        ReturnParam returnParam = Test::doubleNum;
        System.out.println(returnParam.method(10));

        Test test = new Test();
        ReturnParam returnParam1 = test::NumAddTwo;
        System.out.println(returnParam1.method(10));
    }
}
