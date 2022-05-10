package com.jian.sort;

public class MaoPao {
    public static void main(String[] args) {
//        int[] a1 = new int[]{8,2,6,3,9,7,5,4,1};
//        new MaoPao().MaoPaoSort3(a1);
        int[] a1 = new int[]{2,3,4,5,6,7,1,8};
        sort(a1);
    }
    private void MaoPaoSort(int[] arr){
        //外循环次数等于数组长度-1，就是执行多少轮才整齐
        //然后内循环次数就直接-i，因为外循环一次排好，最后两个数字就不用排了，以此类推，外循环两次
        //最后内循环就不用根最后两个已经排好的比较了所以内循环每次都是要多减掉一个i
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                int temp = 0;
            if (arr[j]>arr[j+1]){
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
            }
        }
        for (int a:arr
             ) {
            System.out.print(a);
        }
    }

    public void MaoPaoSort2(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            //有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            for (int j = 0; j < arr.length-i-1; j++) {
                int temp = 0;
                if (arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    //有元素交换，所以不是有序的，标记变为false
                    isSorted = false;
                }
            }
            if (isSorted){
                break;
            }
        }
        for (int a:arr
        ) {
            System.out.print(a);
        }
    }

    public void MaoPaoSort3(int[] arr){
        //记录最后一次元素交换的位置
        int lastExchangeIndex = 0;
        //无序数列的边界，每次比较只需要比到这里为止
        int sortBorder  =arr.length-1;
        for (int i = 0; i < arr.length-1; i++) {
            //有序标记，每一轮的初始值都是true
                boolean isSorted = true;
                for (int j = 0; j < arr.length-i-1; j++) {
                    int temp = 0;
                    if (arr[j]>arr[j+1]){
                        temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                        //有元素交换，所以不是有序的，标记变为false
                        isSorted = false;
                        //更新最后一次元素交换的位置
                        lastExchangeIndex = j;
                    }
            }
            sortBorder = lastExchangeIndex;
            if (isSorted){
                break;
            }
        }
        for (int a:arr
        ) {
            System.out.print(a);
        }
    }

    /**
     * 鸡尾酒排序
     * @param arr
     */
    public static void sort(int[] arr){
        int temp  = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            //有序标记，每一轮的初始值都是true
            boolean isSorted = true;
            //奇数轮，从左向右比较和交换
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    //有元素交换，所以不是有序的，标记变为false
                    isSorted = false;
                }
            }
            if (isSorted){
                break;
            }
            //在偶数轮之前，加你个isSorted重新标记为true
            isSorted = true;
            for (int j = 0; j <arr.length-i-1 ; j++) {
                if (arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    //有元素交换，所以不是有序的，标记变为false
                    isSorted = false;
                }
            }
            if (isSorted){
                break;
            }
        }

        for (int a:arr
        ) {
            System.out.print(a);
        }
    }

}
