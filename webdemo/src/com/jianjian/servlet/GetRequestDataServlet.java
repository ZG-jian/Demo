package com.jianjian.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class GetRequestDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置请求编码，要在第一行加！
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        System.out.println(username);
        String[] userlikes = req.getParameterValues("userlike");
        List<String> strings = Arrays.asList(userlikes);//list会自动调用它的toString
        Enumeration<String> parameterNames = req.getParameterNames();
        List<String> keys = new ArrayList<>();
        while (parameterNames.hasMoreElements()){
            keys.add(parameterNames.nextElement());
        }

        // 使用 Map 结构获取提交数据
        Map<String, String[]> parameterMap = req.getParameterMap();
        resp.setCharacterEncoding("utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Jian</title></head>");
        pw.println("<body>");
        pw.println("UserName:"+username+"</br>");
        pw.println("UserLike:"+strings+"</br>");

        pw.println("Keys:"+keys+"</br>");

        Iterator<Map.Entry<String,String[]>> iterator  = parameterMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,String[]> entry = iterator.next();
            pw.println("Keys:"+entry.getKey()+" Value"+Arrays.asList(entry.getValue())+"</br>");

        }

        pw.println("</body>");
        pw.println("</html>");
        pw.flush();
        pw.close();
    }
}
