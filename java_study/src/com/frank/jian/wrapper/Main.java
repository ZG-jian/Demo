package com.frank.jian.wrapper;

import org.junit.Test;

public class Main {
    public static void main(String[] args) {
        run();
    }
    public static void run(){
        Test01 test01 = new Test01();
        test01.Test();
    }
    @Test
    public void oh(){
        System.out.println(666);
    }
}
