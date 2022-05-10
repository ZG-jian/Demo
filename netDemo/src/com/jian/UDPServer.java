package com.jian;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

//UDP案例，创建服务端
public class UDPServer {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        try {
            //创建服务端接受数据的DatagramSocket对象
            datagramSocket = new DatagramSocket(6666);
            //创建数据缓存区
            byte[] b = new byte[1024];
            //创建数据报包对象
            DatagramPacket dp = new DatagramPacket(b,b.length);
            //等待接收客户端所发送的数据
            datagramSocket.receive(dp);
            //这个0一开始没给，乱码了
            String str = new String(dp.getData(),0,dp.getLength());
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (datagramSocket!=null){
                datagramSocket.close();
            }
        }
    }
}
