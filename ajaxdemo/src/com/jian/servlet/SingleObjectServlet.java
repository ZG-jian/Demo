package com.jian.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jian.pojo.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 通过JSON格式响应单个对象
 */
@WebServlet("/single.do")
public class SingleObjectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建User对象
        Users users = new Users();
        users.setUserid(1);
        users.setUsername("jianjian");

        //使用jackson的api将Users对象转换为JSON格式的对象
        ObjectMapper objectMapper = new ObjectMapper();//对象到json或者json到对象转换都依赖这个对象的api
        //将Users对象准换为JSON格式的对象
        String string = objectMapper.writeValueAsString(users);
        //设置响应类型为application/json
        resp.setContentType("application/json");
        PrintWriter pw  = resp.getWriter();
        pw.println(string);
        pw.flush();
        pw.close();
    }

}
