package com.frank.jian.modular;

import org.junit.Test;

public class Main {
    public static void main(String[] args) {
        run();
    }
    public static void run(){
        TestTestCalculation testTestCalculation = new TestTestCalculation();
        testTestCalculation.TestAdd();
        testTestCalculation.TestSub();
        testTestCalculation.TestMul();
        testTestCalculation.TestDiv();

    }
    @Test//static方法不能测试吗？
    public void oh(){
        System.out.println("66666");
    }
}
