package com.jian;

import java.net.InetAddress;
//获取本机信息
public class InetTest {
    public static void main(String[] args) throws Exception{
        //实例化InetAddress对象
        InetAddress inetAddress = InetAddress.getLocalHost();
        //返回当前计算机的IP地址
        System.out.println(inetAddress.getHostAddress());
        //返回当前计算机名
        System.out.println(inetAddress.getHostName());

    }
}
