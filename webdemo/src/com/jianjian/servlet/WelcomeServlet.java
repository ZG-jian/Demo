package com.jianjian.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 需求：当客户端浏览器第一次访问 Servlet 时返回“您好，欢迎您第一次访问！”，第
 * 二次访问时返回“欢迎您回来！”。
 */
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取cookie
        Cookie[] cookies = req.getCookies();
        boolean flag = false;
        if (cookies!=null){
            for (Cookie cookie:cookies
                 ) {
                if ("first".equals(cookie.getName())){
                    flag = true;
                }

            }
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
            Cookie cookie = new Cookie("first","user");
            cookie.setMaxAge(30);
            //响应给客户端浏览器
            resp.addCookie(cookie);
        }
        pw.println("</body>");
        pw.println("</html>");
        pw.flush();
        pw.close();

    }
}
