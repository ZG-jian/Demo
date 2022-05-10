package com.jian;

public class AvgArray {
    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
    }
    public static double findMaxAverage(int[] nums,int k){
        int sum = 0;
        int n = nums.length;
        //先算第一个窗口的值
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;//最大值
        //直接从k开始，去一个头，加一个尾
        for (int i = k; i <n ; i++) {
            sum = sum-nums[i-k]+nums[i];
            max = Math.max(max,sum);
        }
        return 1.0*max/k;
    }
}
