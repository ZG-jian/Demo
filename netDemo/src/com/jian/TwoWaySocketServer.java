package com.jian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 这样就完成了双向通信的简单实现
 * 但是有一个问题，就是他们两个是同一个线程，服务端向客户端发消息，
 * 客户端必须得再向服务端发消息才能接受到
 */
public class TwoWaySocketServer {
    public static void main(String[] args) {
        Scanner scanner = null;
        ServerSocket serverSocket = null;
        Socket socket = null;
        PrintWriter pw = null;
        BufferedReader br = null;
        try {
            serverSocket = new ServerSocket(6666);
            //服务端启动，开始监听
            socket = serverSocket.accept();
            //键盘输入对象的创建
            scanner = new Scanner(System.in);
            //向客户端发消息对象的创建
            pw = new PrintWriter(socket.getOutputStream());
            //读取客户端消息对象的创建
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true){
                //从客户端接受消息
                String input = br.readLine();
                System.out.println("客户端说："+input);
                if ("exit".equals(input)){
                    break;
                }

                String outPut = scanner.nextLine();
                pw.println(outPut);//向客户端发送消息
                pw.flush();


            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br!= null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (scanner!=null){
                scanner.close();
            }
            if (pw!=null){
                pw.close();
            }
            if (serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
