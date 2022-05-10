package com.jian;

/**
 * 统计N以内的素数
 *
 * 素数，只能被自身和1整除，0，1除外
 */
public class Sushu {
    public static void main(String[] args) {
        System.out.println(bf(100));
        System.out.println(eratosthenes(100));
    }

    //暴力算法   统计个数方法
    public static int bf(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            count += isPrime(i) ? 1 : 0;
        }
        return count;
    }

    //计算和判断方法，i如果能被x整除，则x/i肯定能被x整除，因此只需判断i和根号x之中较小的即可
    private static boolean isPrime(int x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 埃氏筛
     * 利用合数的概念(非素数)，素数*n必然是合数，因此可以从2开始遍历，将所有的合数做上标记
     * @param n
     * @return
     */
    public static int eratosthenes(int n){
        boolean[] isPrime = new boolean[n];//false代表素数
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isPrime[i]){//判断进来就说明2是一个素数
                count++;
                for (int j = 2*i;j<n;j+=i){//j就是合数的标记位   优化后就是i*i， 2*i是没有优化的
                    //因为2×3  后面又有3×2，就重复了，直接i*i开始，就不会有重复的覆盖
                    isPrime[j] = true;
                }
            }
        }
        return count;
    }
}
