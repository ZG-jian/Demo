package com.jian.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 用户退出登录
 */
@WebServlet("/logout.do")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //因为监听器已经做了移除Session的操作，所以在这只需要获取Session并调用销毁方法
        HttpSession session = req.getSession();
        session.invalidate();//然后就出发监听器的sessionDestroyed方法，然后把Session从ServletContext中删除掉，然后Session才会被销毁
        //退出登录后的响应
        resp.sendRedirect("login.jsp");
    }
}
