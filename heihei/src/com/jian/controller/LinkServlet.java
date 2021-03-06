package com.jian.controller;

import com.jian.bean.Data;
import com.jian.bean.Message;
import com.jian.service.LinkService;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet({"/links"})
public class LinkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.描述双方沟通的格式
        response.setContentType("text/json;charset=utf-8");
        //2.通过Service获取数据
        List<Data> links = LinkService.findAll();
        //3.将数据组装为消息
        Message msg = new Message();
        msg.setData(links);
        msg.setMsg("查询成功");
        msg.setStatus(0);//通过格各式各样的状态码来表示出错的类型
        //4.将组装的数据JSON化
        String json = msg.toJSON();
        response.getWriter().append(json);//把JSON给到前端
    }
}
