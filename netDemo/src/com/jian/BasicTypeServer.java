package com.jian;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

//UDP传递基本数据类型服务端
public class BasicTypeServer {
    public static void main(String[] args) {
        DatagramSocket datagramSocket = null;
        DataInputStream ds = null;
        try {
           datagramSocket = new DatagramSocket(9999);
           byte[] b = new byte[1024];
           DatagramPacket datagramPacket = new DatagramPacket(b,b.length);
           datagramSocket.receive(datagramPacket);
           //通过基本数据输入流对象获取数据
            ds = new DataInputStream(new ByteArrayInputStream(datagramPacket.getData()));
            System.out.println(ds.readLong());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (datagramSocket!= null){
                datagramSocket.close();
            }
            if (ds!= null){
                try {
                    ds.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
