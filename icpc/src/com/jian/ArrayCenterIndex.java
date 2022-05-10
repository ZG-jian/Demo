package com.jian;

import java.util.Arrays;

/**
 * 寻找数组中心索引
 */
public class ArrayCenterIndex {
    //第一种方法
    public static int pivotIndex(int[] nums){
        int sum = Arrays.stream(nums).sum();//所有元素的和
        int total  = 0;//从左遍历的总和
        for (int i = 0; i <nums.length ; i++) {
            total+=nums[i];
            if (total == sum){
                return i;
            }
            sum = sum-nums[i];//左边遍历加，然后这里就总和-，就是右边的元素
        }
        return -1;//要是没有找到就返回-1
    }
    /*
    第二种方法，就是遍历左边，然后两倍的遍历值+中心标点值就等于所有值的总和，
    在这里也就是（1+7+3）*2+6
     */
    public static int pivotIndex2(int[] array){
        int sum = Arrays.stream(array).sum();//数字总和
        int total  = 0;
        for (int i = 0; i < array.length; i++) {
            total=total+ array[i];
            if ((total*2+array[i+1])==sum){
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(pivotIndex2(new int[]{1, 7, 3, 6, 5, 6}));
    }
}
