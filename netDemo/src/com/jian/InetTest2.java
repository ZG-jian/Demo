package com.jian;

import java.net.InetAddress;
//根据域名获取计算机信息
public class InetTest2 {
    public static void main(String[] args)throws Exception {
        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress.getHostAddress());
        System.out.println(inetAddress.getHostName());
    }
}
