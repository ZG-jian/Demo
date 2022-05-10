package com.jian.web.servlet;

import com.jian.commons.Constants;
import com.jian.exception.UserNotFoundException;
import com.jian.pojo.Users;
import com.jian.service.UserLoginService;
import com.jian.service.impl.UserLoginServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login.do")//因为请求的是login.do
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String username = req.getParameter("username");
            String usernpwd = req.getParameter("userpwd");
            //取验证码
            String code = req.getParameter("code");
            try {
                HttpSession session = req.getSession();
                String codeTemp  = (String) session.getAttribute(Constants.VALIDATE_CODE_KEY);
                if (codeTemp.equals(code)){
                    UserLoginService userLoginService = new UserLoginServiceImpl();
                    Users users = userLoginService.userLogin(username, usernpwd);
                    //建立客户端与服务端的会话状态,用httpSession
                    session.setAttribute(Constants.USER_SESSION_kEY,users);//再去创建一个常量类,避免出现硬编码的现象

                    ServletContext servletContext = this.getServletContext();
                    //要的key是String类型但是id是Int类型，直接+空串就行  返回Object强转
                    HttpSession temp = (HttpSession) servletContext.getAttribute(users.getUserid()+"");
                    if (temp!=null){
                        //说明已经登录过了
                        servletContext.removeAttribute(users.getUserid()+"");
                        temp.invalidate();
                    }
                    servletContext.setAttribute(users.getUserid()+"",session);//再把新的放里面

                    //使用用重定向方式跳转首页，因为重定向可以改变地址栏的url，请求转发不行
                    //那用户登录成功了，就该显示地址栏的首页，而不是登录页面的url
                    resp.sendRedirect("main.jsp");//登录成功的跳转页面
                }else {
                    //输入的验证码不对
                    req.setAttribute(Constants.REQUEST_MSG,"验证码有误，清重新输入");
                    //做重定向的跳转
                    req.getRequestDispatcher("login.jsp").forward(req,resp);
                }

            }catch (UserNotFoundException e){
                   req.setAttribute("msg",e.getMessage());//取之前业务层放的‘用户名或密码有误’
                   req.getRequestDispatcher("login.jsp").forward(req,resp);//这里肯定就用请求转发了
            }catch (Exception e){
                //500状态码，就是tomcat直接把异常响应给客户端浏览器，servlet是最后一层了，
                // 还是根之前说一样，给用户响应错误页面，而不是异常信息，所以在servlet当中要catch掉所有异常
                e.printStackTrace();
                resp.sendRedirect("error.jsp");//基于重定向方式跳转到错误页面
            }
    }
}
