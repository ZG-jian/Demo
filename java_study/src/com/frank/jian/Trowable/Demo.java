package com.frank.jian.Trowable;

import org.junit.Test;

public class Demo {
    @Test
    public void demo1() {
        try {
            int[] a = {1, 2, 3};
            System.out.println(a[3]);
        } catch (Exception e) {

        }finally {
            System.out.println("异常捕获完成！");
        }
    }
}
