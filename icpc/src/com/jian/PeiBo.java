package com.jian;

/**
 * 求取斐波那契数列第N位的值。
 */
public class PeiBo {
    public static void main(String[] args) {
        System.out.println(calculate(10));
        System.out.println(calculate2(10));
        System.out.println(iterate(10));
    }

    /**
     * 暴力递归
     * @param num 要求的位置
     * @return
     */
    public static int calculate(int num){
        if (num==0){
            return 0;
        }
        if (num==1){
            return 1;
        }
        return calculate(num-1)+calculate(num-2);
    }

    /**
     * 去重递归
     * @param num
     * @return
     */
    public static int calculate2(int num){
        int[] arr = new int[num+1];//第k个位置要存k+1个值
        return recurse(arr,num);
}
    public static int recurse(int[] arr, int num){
        if (num==0){
            return 0;
        }
        if (num==1){
            return 1;
        }
        if(arr[num]!=0){
            return arr[num];//如果存了有就直接返回
        }
         arr[num] =  calculate(num-1)+calculate(num-2);
        return arr[num];
    }

     /**
     * 双指针
     * @param num
     * @return
     */
    public static int iterate(int num){
        if (num==0){
            return 0;
        }
        if (num==1){
            return 1;
        }
        int left = 0,right = 1;
        for (int i = 2; i <=num ; i++) {
            int sum = left+right;
            left = right;
            right = sum;

        }
        return right;
    }
}
