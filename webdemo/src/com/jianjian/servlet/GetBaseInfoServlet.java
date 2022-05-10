package com.jianjian.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetBaseInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        //获取ServletContext对象
        ServletContext servletContext = this.getServletContext();
        String serverInfo = servletContext.getServerInfo();
        int majorVersion = servletContext.getMajorVersion();
        int minorVersion = servletContext.getMinorVersion();
        PrintWriter pw = resp.getWriter();
        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Jian</title></head>");
        pw.println("<body>");
        pw.println("Servlet容器的名称和版本："+serverInfo+"</br>");
        pw.println("Servlet容器所支持的Servlet版本："+majorVersion+"."+minorVersion+"</br>");

        pw.println("</body>");
        pw.println("</html>");
        pw.flush();
        pw.close();
    }
}
