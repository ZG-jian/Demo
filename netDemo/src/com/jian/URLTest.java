package com.jian;

import java.net.URL;

public class URLTest {
    public static void main(String[] args)throws Exception {
        //https加密协议默认的端口是443，http才是80
        URL url = new URL("https://www.baidu.com/s?wd=URL&ie=utf-8&tn=15007414_5_dg");
        System.out.println("获取与此URL相关联协议的默认端口:"+url.getDefaultPort());
        System.out.println("访问资源："+url.getFile());
        System.out.println("主机名："+url.getHost());
        System.out.println("访问资源路径："+url.getPath());
        System.out.println("协议："+url.getProtocol());
        System.out.println("参数部分："+url.getQuery());

    }
}
