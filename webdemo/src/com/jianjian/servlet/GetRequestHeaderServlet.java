package com.jianjian.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class GetRequestHeaderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String header = req.getHeader("Accept-Language");
        Enumeration<String> headerNames = req.getHeaderNames();

        PrintWriter pw = resp.getWriter();
        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Jian</title></head>");
        pw.println("<body>");
        pw.println("Header:"+header+"</br>");
        while (headerNames.hasMoreElements()){
            String key = headerNames.nextElement();
            String value = req.getHeader(key);
            pw.println("key:"+key+"        Value:"+value+"</br>");
        }
        pw.println("</body>");
        pw.println("</html>");
    }
}
