package com.jian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
//一对多聊天服务器
/**
 * 接受消息的线程类
 */
class ChatReceive extends Thread{

    private Socket socket;


    public ChatReceive(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        this.receive();
    }
    private void receive(){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            while (true){
                //读取消息并写入缓存区
                String msg = br.readLine();
                //写入需要同步
                synchronized ("abc") {
                    ChatRoomServer.buf = "{" + this.socket.getInetAddress() + "}" + msg;
                    //唤醒发送消息的线程对象
                    "abc".notifyAll();
                }
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
                if(this.socket!=null){
                    try {
                        this.socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

/**
 * 创建发送消息的线程类
 */
class ChatSend extends Thread{
    private Socket socket;

    public ChatSend(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        this.send();
    }
    private void send(){
        PrintWriter pw = null;

        try {
            pw = new PrintWriter(this.socket.getOutputStream());
            while (true){
                synchronized ("abc"){
                    //让发送消息的线程处于等待状态
                    "abc".wait();
                    //将公共数据区的消息发送给客户端
                    pw.println(ChatRoomServer.buf);
                    pw.flush();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
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

public class ChatRoomServer {
    //定义公共数据区
    public static String buf;

    public static void main(String[] args) {
        System.out.println("Chat Server Version 1.0");
        System.out.println("Server Listen at 8888......");
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8888);
            while (true){
                Socket socket = serverSocket.accept();//死循环重复监听
                System.out.println("连接到:"+socket.getInetAddress());

                //启动线程
                new ChatReceive(socket).start();
                new ChatSend(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
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
