package com.jian;

/**
 * 在不使用sqrt(x)函数的情况下，得到x的平方根的整数部分（正整数）
 * 重点考察，二分法、牛顿迭代
 */
public class SqrtX {
    public static void main(String[] args) {
        System.out.println(binarySearch(25));
        System.out.println(newton(25));
    }
    //二分查找
    public static int binarySearch(int x){
        int index = -1,l = 0,r = x;//l是左指针，r是右指针  错误或者没有找到就返回-1
        //因为0跟1就不行，默认返回-1
        //当l和r重合或者大于时，退出循环
        while(l<=r){
            int mid = l+(r-l)/2;//最中间元素
            if (mid*mid<=x){
                index = mid;//记录返回值
                l = mid+1;//l往右边移位
            }else {
                //最中间元素平方大于x，所以定位左边r = mid-1；
                r = mid-1;
            }
        }
        return index;
    }

    /**
     * 牛顿迭代
     * @param x
     * @return
     */
    public static int newton(int x){
        if (x==0){
            return 0;
        }
        return (int)sqrts(x,x);
    }

    /**
     *
     * @param i  得到的平方根
     * @param x  要求的数
     * @return
     */
    public static double sqrts(double i,int x){
        double res = (i+x/i)/2;
        if (res==i){
            return i;
        }else {
            return sqrts(res,x);
        }
    }
}
