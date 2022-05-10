package com.jian.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * 页面跳转控制器
 */
@Controller
@RequestMapping("/page")
public class PageController {
    /**
     * 跳转单文件上传页面
     */
    @RequestMapping("/single")
    public String showSingleFile(){
        return "singlefile";//然后这个jsp再提交到文件上传的控制器
    }

    /**
     * 跳转成功页面
     */
    @RequestMapping("/ok")
    public String showOK(){
        return "ok";
    }

    /**
     * 跳转多文件上传页面
     */
    @RequestMapping("/multifile")
    public String showMultiFile(){
        return "multifile";
    }

    /**
     * 跳转文件下载页面
     */
    @RequestMapping("/showFileDown")
    public String showFileDown(HttpServletRequest request, Model model){
        String realPath = request.getServletContext().getRealPath("/fileupload");
        File file = new File(realPath);
        String[] arr = file.list();//获取文件的名字然后添加过去，jsp再在读取出来
        model.addAttribute("files",arr);
        return "filedown";
    }

    /**
     * 跳转showimg页面
     */
    @RequestMapping("showimg")
    public String showImg(){
        return "showimg";
    }
}
