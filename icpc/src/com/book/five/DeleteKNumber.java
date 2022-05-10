package com.book.five;

public class DeleteKNumber {
    /**
     * 删除整数的k个数字，活得删除后的最小值
     * @param num 原整数
     * @param k 删除数量
     * @return
     */
    public static String removeKDigits(String num,int k){
        //从做至右删除k个数字
        for (int i = 0; i <k ; i++) {
            boolean flag = false;//删除的开关
            for (int j = 0; j<num.length()-1; j++) {
                    if (num.charAt(j)>num.charAt(j+1)){
                        num = num.substring(0,j)+num.substring(j+1,num.length());
                        flag=true;
                        break;
                    }
            }
          //  如果没找到要删除的数字删除最后一个
            if (!flag){
                num = num.substring(0,num.length()-1);
            }
        }
        //清楚左侧的数字0
        int start = 0;
        for (int i = 0; i < num.length()-1; i++) {
            if (num.charAt(i)!= '0'){
                break;
            }
            start++;
        }
        num = num.substring(start,num.length());

        //如果整数的所有数字都被删除了，返回0
        if(num.length()==0){
            return "0";
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(removeKDigits("123436", 1));
        System.out.println(removeKDigits("31911", 2));
        System.out.println(removeKDigits("3200096", 2));
    }
}

