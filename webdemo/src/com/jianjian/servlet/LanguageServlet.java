package com.jianjian.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 需求：编写一个 Servlet，如果浏览器的语言是 zh-CN，显示“你好，聪明的中国人！”，
 * 如果浏览器的语言设置为 en-US,那么则显示“Hello，American”。
 */
public class LanguageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/html;charset=utf-8");
        String header = req.getHeader("Accept-Language");
        PrintWriter pw = resp.getWriter();
        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Jian</title></head>");
        pw.println("<body>");
        if (header.indexOf("zh-CN") != -1) {
            pw.println("你好，牛皮轰轰的中国人");
        }else if (header.indexOf("en-US") != -1){
            pw.println("hello，American！");
        }else {
            pw.println("不好意思，不支持该语言。");
        }
        pw.println("</body>");
        pw.println("</html>");
        pw.flush();
        pw.close();
    }
}
