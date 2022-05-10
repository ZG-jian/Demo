package com.jian;

import java.util.Arrays;

public class Triangles {
    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{3,2,6,3}));
    }
    public static int largestPerimeter(int[] a){
        Arrays.sort(a);
        //遍历到下标2，因为是i-1和i-2根i比
        for (int i = a.length-1; i >=2 ; i--) {
            if (a[i-1]+a[i-2]>a[i]){
                return a[i-1]+a[i-2]+a[i];
            }
        }
        return 0;
    }
}
