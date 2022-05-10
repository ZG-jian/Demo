package com.jian.web.servlet;

import com.github.pagehelper.PageInfo;
import com.jian.pojo.Users;
import com.jian.service.Impl.UsersServiceImpl;
import com.jian.service.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/usersServlet.do")
public class UsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flag = req.getParameter("flag");
        if("addUsers".equals(flag)){
            this.addUsers(req,resp);
        }else if("findUsers".equals(flag)){
            this.findUsers(req,resp);
        }
    }
    /**
     * 处理添加用户请求
     */
    private void addUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Users users = this.createUsers(req);
        UsersService  usersService = new UsersServiceImpl();
        usersService.addUsers(users);
        resp.sendRedirect("ok.jsp");//为了避免表单重复提交
    }
    /**
     * 获取提交数据
     */
    private Users createUsers(HttpServletRequest req){
        String username = req.getParameter("username");
        String usersex = req.getParameter("usersex");
        Users users = new Users();
        users.setUsername(username);
        users.setUsersex(usersex);
        return users;
    }
    /**
     * 查询用户(分页查询)
     */
    private void findUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Users users = this.createUsers(req);
        String pageIndex = req.getParameter("pageIndex");
        int page = 1;
        //如果在请求当中能拿到当前页，就是显示结果的上一页下一页
        if (pageIndex!=null&&pageIndex.length()>0){
            page = Integer.parseInt(pageIndex);
        }
        UsersService usersService = new UsersServiceImpl();
        PageInfo<Users> pageInfo = usersService.findUSers(page,users);
        req.setAttribute("pageInfo",pageInfo);
        req.setAttribute("users",users);
        //因为我们有数据串带过去，所以不能用重定向，用请求转发
        req.getRequestDispatcher("showUsers.jsp").forward(req,resp);


    }
}


