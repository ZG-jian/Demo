package com.jianjian.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("jian","cool");
        //设置cookie的失效时间，一旦设置了失效时间，该cookie为持久化cookie
        //单位是秒
        cookie.setMaxAge(30);
        resp.addCookie(cookie);
        PrintWriter pw = resp.getWriter();
        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Jian</title></head>");
        pw.println("<body>");
        pw.println("Create Cookie   </br>");
        pw.println("</body>");
        pw.println("</html>");
        pw.flush();
        pw.close();
    }
}
