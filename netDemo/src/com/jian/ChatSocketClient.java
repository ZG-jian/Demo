package com.jian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

//这两个直接复用服务端的两个线程类
/**
 * 发送消息的线程类
 */
class Send1 extends Thread{
    private Socket socket;

    public Send1(Socket socket) {
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
class Receive2 extends Thread{
    private Socket socket;

    public Receive2(Socket socket) {
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
public class ChatSocketClient {
    public static void main(String[] args) {
        //如果在最后还添加一个finally去关闭socket的话就会报异常
       //因为线程类里面就已经完成了关闭，个人判断，但又认为，已经判断关闭了，那么再判断关闭一次为什么会报异常
        Socket socket = null;
        try {
            //传一个地址和端口
             socket  = new Socket("127.0.0.1",6666);
            System.out.println("连接成功");
            new Send(socket).start();
            new Receive(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }

