package com.frank.jian.modular;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class TestTestCalculation {

    Scanner scanner = new Scanner(System.in);

    //注解？后期？   框架？
    @Test
    public void TestAdd() {
        int numberA = ThreadLocalRandom.current().nextInt(-9999,9999);
        int numberB = ThreadLocalRandom.current().nextInt(-9999,9999);
        int sum1 = addition.sum(numberA, numberB);
        Assert.assertEquals(numberA + numberB, sum1);
//        System.out.println("你看");
        System.out.println("随机数相加得：" + sum1);

//        int number1 = scanner.nextInt();
//        int number2 = scanner.nextInt();
//        int sum1 = addition.sum(number1, number2);
        ////断言
//        Assert.assertEquals(number1+number2,sum1);
    }

    @Test
    public void TestSub() {
        int numberA = ThreadLocalRandom.current().nextInt(-9999,9999);
        int numberB = ThreadLocalRandom.current().nextInt(-9999,9999);
        int sum1 = Subtraction.Sub(numberA, numberB);
        Assert.assertEquals(numberA - numberB, sum1);
        System.out.println("随机数相减得：" + sum1);
    }
    @Test
    public void TestMul() {
        int numberA = ThreadLocalRandom.current().nextInt(-9999,9999);
        int numberB = ThreadLocalRandom.current().nextInt(-9999,9999);
        int sum1 = Multiplication.Mul(numberA, numberB);
        Assert.assertEquals(numberA * numberB, sum1);
        System.out.println("随机数相乘得：" + sum1);
    }
    @Test
    public void TestDiv(){
        int numberA = ThreadLocalRandom.current().nextInt(-9999,9999);
        int numberB = ThreadLocalRandom.current().nextInt(-9999,9999);
        int sum1 = Division.Div(numberA, numberB);
        Assert.assertEquals(numberA / numberB, sum1);
        System.out.println("随机数相除得：" + sum1);
    }
}
