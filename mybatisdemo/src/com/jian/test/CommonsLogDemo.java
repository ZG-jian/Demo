package com.jian.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Commons-logging的使用
 */
public class CommonsLogDemo {
    private static final Log log = LogFactory.getLog(CommonsLogDemo.class);
    public static void main(String[] args) {
        log.debug("Commons-Login");
        try {
            String str = null;
            str.length();
        }catch (Exception e){
            log.error("空指针异常");
        }
    }
}
