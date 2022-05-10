package com.jianjian.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet("/fileupload.do")
@MultipartConfig()
public class FileUpLoadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //取请求中的描述
        req.setCharacterEncoding("utf-8");
        String desc = req.getParameter("desc");
        Part part = req.getPart("file");

        //为了防止文件名字重复，截取.后(截取扩展名)并随机生成文件名，就像从网站下载图片一样
        String fileName = UUID.randomUUID().toString()+part.getSubmittedFileName().substring(part.getSubmittedFileName().lastIndexOf("."));
        //接下来是文件上传，要确定文件上回传的目录
        //路径转换
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("imag/" + fileName);
        part.write(realPath);//上传完了

        //给客户端浏览器产生响应
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Jian</title></head>");
        pw.println("<body>");
        pw.println("上传成功！"+desc);
        pw.println("</body>");
        pw.println("</html>");
        pw.flush();
        pw.close();

    }
}
