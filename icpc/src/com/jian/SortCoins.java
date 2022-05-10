package com.jian;

/**
 * 排列硬币
 */
public class SortCoins {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(10));
        System.out.println(arrangeCoins2(10));
        System.out.println(arrangeCoins3(100,100));
    }

    /**
     * 迭代
     * @param n
     * @return
     */
    public static int arrangeCoins(int n){
        for (int i = 1; i <=n ; i++) {
            n = n-i;
            if (n<=i){
                return i;//不够排了就返回
            }
        }
        return 0;
    }
//二分查找
    public static int arrangeCoins2(int n){
        int left = 0,right = n;
     while (left<=right){
         long mid = (right-left)/2+left;
         long cost = ((mid+1)*mid)/2;//消耗了多少
         if (cost==n){
             return (int)mid;
         }else if (cost>n){
             right = (int)mid-1;
         }
         else {
             left = (int)mid+1;
         }
     }
        return right;
    }

//牛顿迭代
    public static int arrangeCoins3(double x,int n){
        if (n==0){
            return 0;
        }
        return sqrts(n,n);

    }

    private static int sqrts(double x, int n) {
        double res = (x+(2*n-x)/x)/2;
        if (res==x){
            return (int)x;
        }
        else {
            return sqrts(res,n);
        }
    }

}
