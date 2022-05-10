package com.jianjian.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class AutoStartServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("Servlet Init..........");
        ServletConfig servletConfig = this.getServletConfig();
        String value = servletConfig.getInitParameter("path");
        //拿到之后通过全局容器servletContext传过去
        ServletContext servletContext = this.getServletContext();
        servletContext.setAttribute("path",value);
        //然后去downFile

    }
}
