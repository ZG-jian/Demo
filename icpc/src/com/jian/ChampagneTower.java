package com.jian;

/**
 * 香槟塔问题
 */
public class ChampagneTower {
    public static void main(String[] args) {
        System.out.println(champagneTower(5,2,1));
    }

    /**
     *
     * @param poured 倒的杯数
     * @param query_row  杯子的行
     * @param query_glass 杯子的列
     * @return
     */
    public static double champagneTower(int poured,int query_row,int query_glass){
        double[][] A = new double[100][100];
        A[0][0] = poured;//第一杯
        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                double d = (A[i][j]-1.0)/2;//每一杯溢出的，都是上一杯满了后溢出的一半
                if(d>0){//溢出的大于0就往下溢
                    A[i+1][j] +=d;//左下角的杯子
                    A[i+1][j+1]+=d;//右下角的杯子
                }
            }
        }
        return Math.min(1,A[query_row][query_glass]);//不能直接返回指定位置，因为可能满的可能不满
    }
}
