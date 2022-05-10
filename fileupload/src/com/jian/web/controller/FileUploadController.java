package com.jian.web.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * 处理文件上传控制器
 */
@Controller
@RequestMapping("/file")
public class FileUploadController {
    /**
     * 处理单个文件上传
     */
    @RequestMapping("/singleFile")
    //MultipartFile参数名称必须要和文件上传file组件的name相同
    // 就是jsp里的--->文件上传：<input type="file" name="file"/><br/>
    // 不相同就得用@RequestParam注解指定@RequestParam("file") MultipartFile 你要不同的参数名
    public String singleFile(MultipartFile file, String username, HttpServletRequest request){
        String fileName = UUID.randomUUID().toString()+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));//方式有很多种的
        //相对路径转绝对路径,还得再注入HttpServletContext
        String realPath = request.getServletContext().getRealPath("/fileupload");
        File temp = new File(realPath,fileName);
        try {
            file.transferTo(temp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/page/ok";
    }

    /**
     * 处理多文件上传
     */
    @RequestMapping("/multifile")
    public String multiFile(MultipartFile file[], HttpServletRequest request){//数组名跟file组件的name相同
        for (MultipartFile temp:file
             ) {
            String fileName = UUID.randomUUID().toString()+temp.getOriginalFilename().substring(temp.getOriginalFilename().lastIndexOf("."));
            String realPath = request.getServletContext().getRealPath("/fileupload");
            File f = new File(realPath,fileName);
            try {
                temp.transferTo(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "redirect:/page/ok";
    }

    /**
     * 实现文件下载,没有视图跳转
     */
    @RequestMapping("/fileDown")
    public void fileDown(String fileName, HttpServletRequest request, HttpServletResponse response){
        //设置响应头
        response.setHeader("Content-Disposition","attachment;filename="+fileName);
        //获取绝对路径
        String realPath = request.getServletContext().getRealPath("/fileupload");
        File file = new File(realPath,fileName);

        //获取字节输出流
        try {
            ServletOutputStream outputStream = response.getOutputStream();
            //读文件，用commons-io
            outputStream.write(FileUtils.readFileToByteArray(file));
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
