package com.jian.servlet;

import com.jian.pojo.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用foreach标签迭代List
 */
@WebServlet("/findUser.do")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Users> list = new ArrayList<>();
        Users users1  = new Users(1,"Jian");
        Users users2  = new Users(2,"Frank");
        list.add(users1);
        list.add(users2);

        //通过请求转发的方式
        req.setAttribute("list",list);
        req.getRequestDispatcher("showUsers.jsp").forward(req,resp);

    }
}
