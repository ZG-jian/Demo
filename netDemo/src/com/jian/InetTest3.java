package com.jian;

import java.net.InetAddress;
//根据IP获取计算机信息
public class InetTest3 {
    public static void main(String[] args)throws Exception {
        InetAddress inetAddress = InetAddress.getByName("110.242.68.3");
        System.out.println(inetAddress.getHostAddress());
        System.out.println(inetAddress.getHostName());
    }
}
