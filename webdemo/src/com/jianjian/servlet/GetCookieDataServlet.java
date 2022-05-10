package com.jianjian.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetCookieDataServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        PrintWriter pw = resp.getWriter();
        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Jian</title></head>");
        pw.println("<body>");
        pw.println("Create Cookie   </br>");
        for (int i = 0; i <cookies.length ; i++) {
            Cookie cookie = cookies[i];
            pw.println("Name:"+cookie.getName()+"  Value:"+cookie.getValue()+"</br>");
        }
        pw.println("</body>");
        pw.println("</html>");
        pw.flush();
        pw.close();
    }
}
