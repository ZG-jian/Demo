package com.jianjian;

public class Testif1 {
    public static void main(String[] args){
        int Suiji1 = 1 + (int)(Math.random()*6);
        int Suiji2 = 1 + (int)(Math.random()*6);
        int Suiji3 = 1 + (int)(Math.random()*6);
        //生成[0,1)
        int count = Suiji1+Suiji2+Suiji3;
    if(count <= 10){
        System.out.println("你今天运气不好，下次再来吧！");
    }
    if(count>10&&count<=15) {
        System.out.println("运气一般昂，不如去喝一口水？");
    }
    if(count>15){
        System.out.println("今天运气真不错，干他！");
    }
        System.out.println("第一个骰子："+Suiji1+ "第二个骰子：" +Suiji2+
                "第三个骰子：" +Suiji3+"总分为" +count);

    }
}
