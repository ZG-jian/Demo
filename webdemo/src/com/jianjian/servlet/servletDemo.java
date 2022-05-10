package com.jianjian.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class servletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //返回客户端浏览器发出请求时的完整 URL。
        StringBuffer requestURL = req.getRequestURL();
        //返回请求行中指定资源部分。
        String requestURI = req.getRequestURI();
        //返回发出请求的客户机的 IP 地址。
        String remoteAddr = req.getRemoteAddr();
        ServletContext servletContext = this.getServletContext();
        PrintWriter pw = resp.getWriter();
        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Jian</title></head>");
        pw.println("<body>");
        pw.println("URL:"+requestURL+"</br>");
        pw.println("URI:"+requestURI+"</br>");
        pw.println("RemoteAddr:"+remoteAddr+"</br>");
        String value1 = (String) servletContext.getAttribute("key1");
        String value2 = (String) servletContext.getAttribute("key2");
        pw.println("Value1:"+value1+"</br>");
        pw.println("Value2:"+value2+"</br>");
        pw.println("</body>");
        pw.println("</html>");
        pw.flush();
        pw.close();


    }
}
