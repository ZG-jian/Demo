package com.jian.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 7, 6, 5, 3, 2,8,1,9};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        //d递归结束条件：startIndex大于或等于endIndex时
        if (startIndex > endIndex) {
            return;
        }
        //得到基准元素的位置
        int pivotIndex = partition(arr, startIndex, endIndex);
        //根据基准元素，分成两个部分进行递归排序
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);

    }

    /**
     * 分治（双边循环法）
     *
     * @param arr        待交换的数组
     * @param startIndex 起始下标
     * @param endIndex   结束下标
     * @return
     */
    private static int partition(int[] arr, int startIndex, int endIndex) {
        //取第一个位置（也可以选择随机位置）的元素作为基准元素
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        //只要左右指针没有重合，就继续交换
        while (left != right) {
            //控制right指针比较并左移
            while (left < right && arr[right] > pivot) {
                right--;
            }
            //控制left指针比较并右移
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            //交换left和right指针所指向的元素
            if (left < right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }
        //pivot和指针重合点的交换
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }

    /**
     *  分治（单边循环法）
     * @param arr   待交换的数组
     * @param startIndex  起始下标
     * @param endIndex  结束下标
     * @return
     */
    private static int partition2(int[] arr, int startIndex, int endIndex) {
        //取第一个位置（也可以选择随机位置）的元素作为基准元素
        int pivot = arr[startIndex];
        int mark = startIndex;
        for (int i = startIndex; i <=endIndex ; i++) {
            //遍历到小的就交换mark位置与那个小的
            if (arr[i]<pivot){
                mark++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }
        //pivot与mark位置元素交换
        arr[startIndex] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

}
