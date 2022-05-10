package com.jian;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class BasicTypeClient {
    public static void main(String[] args) {
        Long num = 2002L;
        //因为ByteArrayOutputStream也要使用，所以不能嵌套new
        ByteArrayOutputStream bos = null;
        DataOutputStream dos = null;
        DatagramSocket datagramSocket = null;
        try {
            bos = new ByteArrayOutputStream();
            dos = new DataOutputStream(bos);
            dos.writeLong(num);
            //将基本数据类型数据转换成字节数组类型
            byte[] arr = bos.toByteArray();
            //打包已经确定发送到哪个位置的哪个端口
            DatagramPacket dp = new DatagramPacket(arr,arr.length,new InetSocketAddress("127.0.0.1",9999));
            datagramSocket = new DatagramSocket(1234);//确定客户端发送端口，好像是不给就按照默认端口发送
            //发送
            datagramSocket.send(dp);

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (datagramSocket!= null){
                datagramSocket.close();
            }
            if (dos!=null){
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
