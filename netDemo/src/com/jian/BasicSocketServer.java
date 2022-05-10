package com.jian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
//创建服务端
//要先启动服务端再去启动客户端
public class BasicSocketServer {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader br = null;
        try {
            ServerSocket serverSocket = new ServerSocket(6666);
            System.out.println("服务器启动监听，等待连接。。。。");
            //开启端口的监听
            socket = serverSocket.accept();//accept返回socket对象
            //读取客户端发送的消息
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (socket!= null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
