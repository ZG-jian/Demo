package com.frank.jian;

import java.util.Arrays;

public class VariableParameter {
    public static void main(String[] args) {
        method(1, 2, 3, 4, 5);
    }

    public static int method(int ... ints) {
        System.out.println("可变参数（数组）：" + Arrays.toString(ints));
        System.out.println("可变参数（数组）长度，即数组元素个数：" + ints.length);
        return 0;
    }
}
