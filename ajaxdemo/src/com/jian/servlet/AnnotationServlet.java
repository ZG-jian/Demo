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
 * JackSon常用注解1的使用
 */
@WebServlet("/ann.do")
public class AnnotationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users users = new Users();
        users.setUsername("jian");
        users.setUserid(1);
        ObjectMapper objectMapper = new ObjectMapper();
        String string = objectMapper.writeValueAsString(users);
        System.out.println(string);

        resp.setContentType("application/json");
        PrintWriter pw =resp.getWriter();
        pw.print("Jackson Annotation");
        pw.flush();
        pw.close();
    }
}
