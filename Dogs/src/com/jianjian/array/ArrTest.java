package com.jianjian.array;


import java.util.Arrays;
/*
 java.util.Arrays 类
 */
public class ArrTest {
    public static void main(String[] args) {
        int[] arr_1 = {151,782,53,464,895,666,237,28};
        //排列
        Arrays.sort(arr_1);
        for (int a:arr_1
             ) {
            System.out.println(a);
        }
        //二分查找，必须先排列
        int result_index = Arrays.binarySearch(arr_1,666);
        System.out.println(result_index);
        int[] arr_2 = {1,2,3};
        int[] arr_3 = {1,2,3};
        boolean result = Arrays.equals(arr_2,arr_3);
        System.out.println(result);

        int[] arr4 = {44,55,66,77,88,99,100};
        System.out.println(arr4);
        //此处的 Arrays.toString()方法是 Arrays 类的静态方法，不是前面讲的 Object 的 toString()
        //方法。
        System.out.println(Arrays.toString(arr4));
        //填充，取头不取尾
        Arrays.fill(arr4,2,4,520);
        System.out.println(Arrays.toString(arr4));

        //二维数组
        int[][] arrMore = new int[3][];
//        arrMore[1] = {11,12,13};这样不行，错误，没有声明类型就初始化
        arrMore[0] = new int[] {11,12,13};
        arrMore[1] = new int[] {111,122,133};
        arrMore[2] = new int[] {1111,1222,1333};
        System.out.println(arrMore[2][2]);
        //当你从arrMore[1]开始给数据不是[0]开始，运行才报错

    }

}
