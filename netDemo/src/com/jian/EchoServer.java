package com.jian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
//一对多问答型聊天服务器
/**
 * 定义消息处理线程类
 */
class Msg extends Thread{
    private Socket socket;

    public Msg(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        this.msg();
    }

    private void msg(){
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            pw = new PrintWriter(this.socket.getOutputStream());
            while (true){
                pw.println(br.readLine()+"   [复读机]");
                pw.flush();
            }

        }catch (Exception e){
            System.out.println(this.socket.getInetAddress()+"断线了");
            e.printStackTrace();
        }
        finally {
            if (br!= null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (pw!=null){
                pw.close();
            }
        }

    }
}
public class EchoServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6666);
            while (true){
                //一直监听
                Socket socket = serverSocket.accept();
                new Msg(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (serverSocket!= null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
