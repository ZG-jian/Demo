package com.jianjian.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class DownFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ServletContext对象
        ServletContext servletContext = this.getServletContext();
     String path = (String)servletContext.getAttribute("path");
        System.out.println(path);
        //路径转换
        String realPath = servletContext.getRealPath(path+"/chuyin.jpg");
        System.out.println(realPath);

        //读文件
        File file = new File(realPath);
        System.out.println(file.getName());
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));

        //写文件
        BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream());
        //修改响应头，添加附加信息。
        resp.addHeader("Content-Disposition","attachment; filename="+file.getName());
        int by;
        while ((by = bis.read())!=-1){
            bos.write(by);
        }
        bos.flush();
        bos.close();
        bis.close();
    }
}
