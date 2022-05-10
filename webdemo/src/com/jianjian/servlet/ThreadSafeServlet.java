package com.jianjian.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ThreadSafeServlet extends HttpServlet {
    private PrintWriter pw;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        synchronized (this){
            pw = resp.getWriter();
            try {
                Thread.sleep(5000);
                pw.println(name);
                pw.flush();
                pw.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
