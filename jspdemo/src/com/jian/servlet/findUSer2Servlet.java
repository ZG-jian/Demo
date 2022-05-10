package com.jian.servlet;

import com.jian.pojo.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@WebServlet("/findUser2.do")
public class findUSer2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Users> map = new HashMap<>();
        Users u1 = new Users(1,"Jian");
        Users u2 = new Users(2,"Frank");
        map.put("user1",u1);
        map.put("user2",u2);
        req.setAttribute("map",map);
        req.getRequestDispatcher("showUser2.jsp").forward(req,resp);

    }
}
