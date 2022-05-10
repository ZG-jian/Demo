package com.jian.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4JDemo {
    private final static Logger logger = LoggerFactory.getLogger(SLF4JDemo.class);

    public static void main(String[] args) {
        logger.debug("SLF4J");
        try {
            String str = null;
            str.length();
        }catch (Exception e){
            logger.error("AAAA",e);
        }
    }
}
