package com.jian;

public class SortedArrayDuplicates {
    public static void main(String[] args) {
       int[] arr =  new int[]{0, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(arr));
        for (int a:arr
             ) {
            System.out.println(a);
        }
    }
    public static int removeDuplicates(int[] nums){
        //如果是空数组直接返回0
        if (nums.length==0){
            return 0;
        }
        int i = 0;
        for (int j = 1;j<nums.length;j++){
            if (nums[j]!=nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
