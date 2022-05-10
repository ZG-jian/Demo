package com.jian.sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] a1 = new int[]{8,2,6,3,10,9,7,5,4,1};
        new SelectSort().selection_sort(a1);
    }

    /**
     *选择排序
     * @param arr 传进来的数组
     */
    public void selection_sort(int[] arr){
        for (int i = 0; i < arr.length; ++i) {
            int ith = i;//用来决定最小元素的
            for (int j = i+1;j<arr.length;++j){//md，OI-wiki里内循环是<=然后直接报数组下标越界
                if (arr[j]<arr[ith]){
                    ith = j;//把最小元素的下标给ith
                    //一轮循环后ith获得这轮最小的值的小下标
                }
            }
            if (i!=ith) {
                int t = arr[i];//先存第i个元素的值，后面要交换
                arr[i] = arr[ith];//修改，把第i小的的给i位置
                arr[ith] = t;//交换完毕
            }
        }

        for (int ele:arr
             ) {
            System.out.print(ele);
        }
    }
}
/*OutPut：12345678910
* */