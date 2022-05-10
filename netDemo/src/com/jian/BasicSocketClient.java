package com.jian;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class BasicSocketClient {
    public static void main(String[] args) {
        Socket socket = null;
        PrintWriter pw = null;

        try {
            //创建Socket对象，两个参数，1：服务器的IP地址，2：服务器所监听的端口
            socket = new Socket("127.0.0.1",6666);
            pw = new PrintWriter(socket.getOutputStream());
            pw.println("服务器，你好qwq");
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (pw!= null){
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
