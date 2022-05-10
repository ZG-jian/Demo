package com.jian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TwoWaySocketClient {
    public static void main(String[] args) {
        Scanner scanner = null;
        PrintWriter pw = null;
        Socket socket = null;
        BufferedReader br = null;

        try {
            socket = new Socket("127.0.0.1",6666);
            //创建向客户端发消息对象
            pw = new PrintWriter(socket.getOutputStream());
            //创建接受服务端消息对象
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //创建键盘输入对象
            scanner = new Scanner(System.in);
            while (true){
                String outPut = scanner.nextLine();
                pw.println(outPut);
                pw.flush();
                if ("exit".equals(outPut)){
                    break;
                }
                String input = br.readLine();
                System.out.println("服务端说："+input);

            }




        } catch (IOException e) {
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
            if(pw!=null){
                pw.close();
            }
            if (scanner!=null){
                scanner.close();
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
