package com.jianjian.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GlobalContainerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取servletContext对象
        ServletContext servletContext = this.getServletContext();
        servletContext.setAttribute("key1","Jian");
        servletContext.setAttribute("key2","Frank");
        PrintWriter pw = resp.getWriter();
        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Jian</title></head>");
        pw.println("<body>");
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
