package com.sxt.Lambda;

/**
 * 无返回值无参数
 */
@FunctionalInterface
interface NoReturnNoParam{
    void method();
}

/**
 * 无返回值一个参数
 */
@FunctionalInterface
interface NoReturnOneParam{
    void method(int a);
}

/**
 * 无返回值多参数
 */
@FunctionalInterface
interface  NoReturnMulParam{
    void method(int a, int b);
}

/**
 * 有返回值无参数
 */
@FunctionalInterface
interface ReturnNOParam{
    int method();
}

/**
 * 有返回值一个参数
 */
@FunctionalInterface
interface ReturnParam{
    int method(int a);
}

/**
 * 有返回值多参数
 */
@FunctionalInterface
interface ReturnMulParam{
    int method(int a, int b);
}
//实现函数接口
public class Test {
    public static void main(String[] args) {

        NoReturnNoParam noReturnNoParam = ()->{
            System.out.println("NoReturnNoParam");
        };
        noReturnNoParam.method();

        NoReturnOneParam noReturnOneParam = a-> System.out.println("NoReturnOneParam"+a);
        noReturnOneParam.method(99);

        NoReturnMulParam noReturnMulParam = (a,b)-> System.out.println("NoReturnMulParam"+a+"\t"+b);
        noReturnMulParam.method(11,22);

        ReturnNOParam returnNOParam = ()->{
            System.out.print("ReturnNOParam");
          return 456;
        };
        System.out.println(returnNOParam.method());

        ReturnParam returnParam = a->a;

        System.out.println(returnParam.method(88));


        ReturnMulParam returnMulParam = (a,b)-> a+b;
        System.out.println(returnMulParam.method(6, 94));

    }
    public static int doubleNum(int a){
        return 2*a;
    }
    public int NumAddTwo(int a){
        return a+2;
    }
}
