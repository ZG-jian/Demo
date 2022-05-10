package com.jianjian.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class WelcomeSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        boolean flag = true;
        if (session==null){
            flag=false;
            req.getSession();
        }
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Jian</title></head>");
        pw.println("<body>");
        if (flag){
            pw.println("欢迎您回来！");
        }else {
            pw.println("您好，欢迎您第一次访问！");
        }
        pw.println("</body>");
        pw.println("</html>");
        pw.flush();
        pw.close();
    }
}
