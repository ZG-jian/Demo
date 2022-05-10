package com.jian.web.servlet;

import com.jian.service.UsersService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/addUsers.do")
public class UsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //方式一
      /*  WebApplicationContext webApplicationContext = (WebApplicationContext) this.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        UsersService usersService = (UsersService) webApplicationContext.getBean("usersServiceImpl");
        usersService.addUsers();
        resp.getWriter().print("Hello!  Servlet");*/

      //方式二
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        UsersService usersService = (UsersService) webApplicationContext.getBean("usersServiceImpl");
        usersService.addUsers();
        resp.getWriter().print("Hello!  Servlet");

    }
}
