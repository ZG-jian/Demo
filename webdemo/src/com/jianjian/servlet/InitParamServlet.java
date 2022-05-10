package com.jianjian.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 通过注解方式读取Servlet的初始化配置信息
 */
@WebServlet(urlPatterns = "/initParam.do",initParams = {@WebInitParam(name = "key1",value = "value1"),@WebInitParam(name = "key2",value = "value2")},loadOnStartup = 1)
public class InitParamServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        ServletConfig servletConfig = this.getServletConfig();
        System.out.println(servletConfig.getInitParameter("key1"));
        System.out.println(servletConfig.getInitParameter("key2"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = this.getServletConfig();
        PrintWriter pw = resp.getWriter();
        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Jian</title></head>");
        pw.println("<body>");
        pw.println("Value1:"+servletConfig.getInitParameter("key1")+"</br>");
        pw.println("Value1:"+servletConfig.getInitParameter("key2 ")+"</br>");
        pw.println("</body>");
        pw.println("</html>");
        pw.flush();
        pw.close();
    }
}
