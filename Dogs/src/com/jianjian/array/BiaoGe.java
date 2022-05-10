package com.jianjian.array;

import java.util.Arrays;
/*
使用二维数组保存表格数据
 */
public class BiaoGe {
    public static void main(String[] args) {
        Object[] emp0 = {0001,"张三","和尚",19};
        Object[] emp1 = {0002,"李四","乞丐",17};
        Object[] emp2 = {0003,"王五","程序员",28};

        Object[][] emps = new Object[3][];
        emps[0] = emp0;
        emps[1] = emp1;
        emps[2] = emp2;
//        System.out.println(Arrays.toString(emp0));
//        System.out.println(Arrays.toString(emp1));
//        System.out.println(Arrays.toString(emp2));

//        for (int i = 0; i < emps.length; i++) {
//            System.out.println(Arrays.toString(emps[i]));
//        }

        for (int i = 0; i < emps.length; i++) {
            for (int j = 0; j < emps[i].length; j++) {
                System.out.print(emps[i][j]+"\t");

            }
            System.out.println();

        }
    }
}
