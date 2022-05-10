package com.jian;
//点对点聊天优化

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 发送消息的线程类
 */
class Send2 extends Thread{
    private Socket socket;
    private Scanner scanner;

    public Send2(Socket socket,Scanner scanner) {
        this.socket = socket;
        this.scanner = scanner;
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
class Receive3 extends Thread{
    private Socket socket;

    public Receive3(Socket socket) {
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
public class GoodTCP {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;//这个要在下面关闭，连接好后这个就没有用了
        //这些都在线程类里面关闭了
        Socket socket = null;
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            System.out.println("请输入：server，<port>或者<ip>,<port>");
            String str = scanner.nextLine();//获取判断的输入
            String[] arr = str.split(",");//选择分割符并且存入数组

            //利用传递的socket的差异来决定启动的是客户端还是服务端
            if ("server".equals(arr[0])){
                //启动服务端
                System.out.println("TCP server Listen at:"+arr[1]);
                serverSocket = new ServerSocket(Integer.parseInt(arr[1]));//转为int的端口
                socket = serverSocket.accept();//正式启动
                System.out.println("连接成功");

            }else {
                //启动客户端
                socket = new Socket(arr[0],Integer.parseInt(arr[1]));
                System.out.println("连接成功");

            }
            //判断好了启动哪个端，开始启动
            new Send2(socket,scanner).start();
            new Receive3(socket).start();

        }catch (Exception e){
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
