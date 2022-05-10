package com.jian;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5, 6}, 10)));
        System.out.println(Arrays.toString(solution2(new int[]{1, 2, 3, 4, 5, 6}, 10)));
        System.out.println(Arrays.toString(twoSearch(new int[]{1, 2, 3, 4, 5, 6}, 10)));
        System.out.println(Arrays.toString(twoPoint(new int[]{1, 2, 3, 4, 5, 6}, 10)));
    }

    /**
     * 暴力算法
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] solution(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 哈希表  将数组的值作为key存入map
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] solution2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int low = i, high = nums.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (nums[mid] == target - nums[i]) {
                    return new int[]{i, mid};
                } else if (nums[mid] > target - nums[i]) {
                    high = mid - 1;
                } else if (nums[mid] < target - nums[i]) {
                    low = mid + 1;
                }
            }
        }
        return new int[0];
    }

    /**
     * 双指针，最优解
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoPoint(int[] nums,int target){
        int left = 0,right = nums.length-1;//左右指针
        while(left<right){
            int sum = nums[left]+nums[right];
            if (sum==target){
                //如果找到就返回
                return new int[]{left,right};
            }else if (sum<target){
                left++;
            }else {
                right--;
            }
        }
        return new int[0];
    }

}
