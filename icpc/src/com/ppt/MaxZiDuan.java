package com.ppt;

public class MaxZiDuan {
    public static void main(String[] args) {
        System.out.println(maxSumDP(new int[]{-2,11,-4,13,-5}));
    }
    public static int maxSumDP(int[] a){
        int[] m = new int[a.length];//用来存放值
        int max = 0;
        for (int i = 1; i <a.length ; i++) {
            if (m[i-1]>0){//如果前一个的最大字段的值>0
                m[i] = m[i-1]+a[i];
            }else {
                m[i] = a[i];//小于0的话就最优值就直接=它本身，因为前面的最优值都<0，本身正负没关系了
            }
            if (m[i]>max){//如果某个位置的值都比前面的最大字段大
                max = m[i];
            }
        }
        return max;
    }
}
