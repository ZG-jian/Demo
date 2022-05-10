package com.jian;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
//UDP案例创建客户端
public class UDPClient {
    public static void main(String[] args) {
        DatagramSocket ds = null;
        try {
            //消息需要进行数据转换，转换为字节数据类型
            byte[] b = "请问木叶村怎么走".getBytes();
            //创建数据报包对象DatagramPacket,传递发送地址
            DatagramPacket dp = new DatagramPacket(b,b.length,new InetSocketAddress("127.0.0.1",6666));
            //创建数据发送对象DatagramSocket，需要指定消息的发送端口
            ds = new DatagramSocket(8888);
            //发送消息
            ds.send(dp);

        }catch (Exception e){
            e.printStackTrace();
        }
        if (ds!= null){
            ds.close();
        }
    }
}
