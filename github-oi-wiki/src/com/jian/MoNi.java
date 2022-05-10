package com.jian;

import java.util.Scanner;

public class MoNi {
    public static void main(String[] args) {
        int n = 0, u = 0 ,d = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入n    u   d");
        n = scanner.nextInt();
        u = scanner.nextInt();
        d = scanner.nextInt();
        int time = 0;//时间
        int dist = 0;//爬行高度

        if (n!=0) {
            while (true){//死循环来枚举
            dist +=u;//每分钟爬行高度和
            time++;
            if (dist>n) break;
            dist-=d;//减去每分钟掉落
            }
        }else {
            return;
        }

        System.out.println(time);
    }
}
