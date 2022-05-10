package com.jianjian.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * HttpSession创建过程
 */
public class CreateHttpSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        //谁访问就给谁生成一个session
        String header = req.getHeader("User-Agent");
        if (header.indexOf("Chrome")!=-1){
            httpSession.setAttribute("Jian","Chrome");
            //给值后就销毁，查就是空
            httpSession.invalidate();
        }else {
            httpSession.setAttribute("Jian","ME");
        }

        String id = httpSession.getId();
        System.out.println(httpSession+"    "+id);
        PrintWriter pw = resp.getWriter();
        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Jian</title></head>");
        pw.println("<body>");
        pw.println("Create HttpSession      "+id);
        pw.println("</body>");
        pw.println("</html>");
        pw.flush();
        pw.close();
    }
}
