package com.jian.test;

import org.apache.log4j.Logger;

/**
 * Log4j的使用
 */
public class LogDemo {
    private final static Logger logger = Logger.getLogger(LogDemo.class);
    public static void main(String[] args) {
        //logger里面的方法对应响应的日志级别
        String str = "jianLog";
        logger.debug(str);
        /**
         * 在这里只要把配置文件的debug改为info，这个就不会输出了，就相当于
         * 删除system.out之类的
         */
        try {
            String temp = null;
            temp.length();
        }catch (Exception e){
            logger.debug(e);
            logger.error(e);
        }

    }
}
