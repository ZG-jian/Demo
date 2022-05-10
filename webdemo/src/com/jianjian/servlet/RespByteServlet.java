package com.jianjian.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class RespByteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //读取图片文件,跟视频不同，使用字节缓冲流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\jianjian\\Desktop\\other\\壁纸\\chuyin.jpg"));

        //设置响应类型
        resp.setContentType("image/jpeg ");
        //从HttpServletResponse对象中获取字节输出流对象
        BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream());
        int by;
        while ((by = bis.read())!=-1){
            bos.write(by);
        }
        bos.flush();
        bos.close();
        bis.close();
    }
}
