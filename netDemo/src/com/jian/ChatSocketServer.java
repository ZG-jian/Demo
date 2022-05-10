package com.jian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
//点对点聊天服务端

/**
 * 发送消息的线程类
 */
class Send extends Thread{
    private Socket socket;

    public Send(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        this.sendMsg();
    }

    /**
     * 发送消息方法
     */
    public void sendMsg(){
        Scanner scanner = null;
        PrintWriter pw = null;
        try {
            //创建Scanner对象
            scanner = new Scanner(System.in);
            //创建向对方输出消息对象
            pw = new PrintWriter(this.socket.getOutputStream());
            while (true){
                String msg = scanner.nextLine();
                pw.println(msg);
                pw.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (scanner!=null){
                scanner.close();
            }
            if (pw!= null){
                pw.close();
            }
            if (this.socket!=null){
                try {
                    this.socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

/**
 * 接受消息的线程
 */
class Receive extends Thread{
    private Socket socket;

    public Receive(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        this.receiveMsg();
    }

    /**
     * 接受消息方法
     */
    public void receiveMsg(){
        BufferedReader br = null;

        try {
            //创建用于接受消息的对象
            br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            while (true){
                String msg = br.readLine();
                System.out.println("他说："+msg);
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
            if (this.socket!= null){
                try {
                    this.socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class ChatSocketServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(6666);
            System.out.println("服务端启动，等待连接。。。。");
            Socket socket = serverSocket.accept();
            System.out.println("连接成功");
            //创建收发消息线程并把此服务端的socket传入并启动
            new Send(socket).start();
            new Receive(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
