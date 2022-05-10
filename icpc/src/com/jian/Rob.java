package com.jian;

public class Rob {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        int[] nums1 = new int[]{2, 7, 9, 3, 1};
        System.out.println(maxMoney(nums, nums.length - 1));
        System.out.println(maxMoney(nums1, nums1.length - 1));
        System.out.println("----------------");
        System.out.println(maxMoney1(nums));
        System.out.println(maxMoney1(nums1));

        System.out.println(Math.max(maxMoney2(nums, 0, nums.length - 2), maxMoney2(nums, 1, nums.length - 1)));
    }

    /**
     * 递归
     *
     * @param nums  数组
     * @param index 最后下标位置
     * @return
     */
    static int maxMoney(int[] nums, int index) {
        if (nums == null || index < 0) {
            return 0;
        }
        if (index == 0) {
            return nums[0];
        }
        return Math.max(maxMoney(nums, index - 2) + nums[index], maxMoney(nums, index - 1));
    }

    /**
     * 动态规划
     *空间复杂度可以优化，因为我们求的是最后一个，就没有必要开空间存之前的
     * @param nums
     * @return
     */
    static int maxMoney1(int[] nums) {
        int length = nums.length;
        //dp数组

        if (nums == null || length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        /*
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i<length ; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);//每一个位置的最优解
        }*/

        //优化
        int first = nums[0],second = nums[1];
        for (int i = 2; i < length; i++) {
            int temp = second;
            second  = Math.max(first+nums[i],second);//找出本轮最优解
            first = temp;//记录上一个最优解？？
        }

        return second;//最后一个位置的最优解
    }

    //首尾相连--拆开变成两个，然后判断选大的
    // Math.max(maxMoney2(nums, 0, nums.length - 2), maxMoney2(nums, 1, nums.length - 1)
    static int maxMoney2(int[] nums,int start,int end) {
        int first = nums[start],second = Math.max(nums[start],nums[start+1]);
        for (int i = start+2; i < end; i++) {
            int temp = second;
            second  = Math.max(first+nums[i],second);//找出本轮最优解
            first = temp;//记录上一个最优解？？
        }

        return second;//最后一个位置的最优解

    }
}
