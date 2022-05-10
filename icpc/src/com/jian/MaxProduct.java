package com.jian;

import java.util.Arrays;

public class MaxProduct {
    public static void main(String[] args) {
        System.out.println(sort(new int[]{1,2,3,4,5,6}));
        System.out.println(getMaxMin(new int[]{1,2,3,4,5,6}));
    }

    /**
     * 排序
     * @param nums
     * @return
     */
    public static int sort(int[] nums){
        Arrays.sort(nums);
        int length = nums.length;
        return Math.max(nums[0]*nums[1]*nums[length-1],nums[length-3]*nums[length-2]*nums[length-1]);
    }

    /**
     * 线性扫描
     * @param nums
     * @return
     */
    public static int getMaxMin(int[] nums){
        //最小的和第二小的
        int min1 = 0,min2 = 0;
        //最大的，第二大的，第三大的
        int max1 = 0,max2 = 0,max3 = 0;
        for (int x:nums
             ) {
            if (x<min1){
                min2 = min1;
                min1 = x;
            }else if (x<min2){
                min2 = x;
            }

            if (x>max1){
                max3 = max2;
                max2 = max1;
                max1 = x;
            }else if (x>max2){
                max3 = max2;
                max2 = x;
            } else if (x>max3){
                max3 = x;
            }
        }
        return Math.max(min1*min2*max1,max1*max2*max3);
    }
}
