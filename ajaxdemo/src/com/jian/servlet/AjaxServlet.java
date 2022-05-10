package com.jian.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ajax.do")
public class AjaxServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //注意，对于给异步请求所处理的响应，千万不要用请求转发或者重定向的跳转方式，这样就是浏览器处理响应
        //得用字符输出流，推回去
        PrintWriter pw = resp.getWriter();
        pw.println("Hello Ajax");
        pw.flush();
        pw.close();

    }
}
