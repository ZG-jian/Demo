package com.jian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 单向通信服务器类
 */
//为什么ServerSocket不在外面创建而最后关闭，因为服务器就是一直开着的，要关就执行完关或者
//添加一个判断条件关
public class OneWaySocketServer {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader br = null;
        PrintWriter pw = null;

        try {
            ServerSocket serverSocket = new ServerSocket(6666);
            System.out.println("服务端启动，开始监听。。。");
            socket = serverSocket.accept();//开启端口的监听
            System.out.println("连接成功！");
            //读取客户端发送的消息
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //向客户端回消息的流对象
            pw = new PrintWriter(socket.getOutputStream());

            while (true){
                String str = br.readLine();
                System.out.println("客户端说："+str);

                if ("exit".equals(str)){
                    break;
                }
                //往客户端写，返回
                pw.println(str);
                pw.flush();
            }

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
            if (pw!=null){
                pw.close();
            }
            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
