package com.frank.jian.Trowable;

import java.io.FileNotFoundException;

public class Test {
    //抛出自定义异常，继承Exception，谁调用谁就处理
    public int sum(int a, int b) throws JianException {
        if (a > 10 || b > 10 || a < 0 || b < 0) {
            throw new JianException("只能求10以内的加法");
        }
        return a + b;
    }
@org.junit.Test
    public void test() {
        try {
            int a =  sum(100, 200);
        } catch (JianException e) {
            e.printStackTrace();
        }

    }
}
