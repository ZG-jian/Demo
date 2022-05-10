package com.jianjian.frank_api.random;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Test {
    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt(10);
        System.out.println(i);
        int i1 = new Random().nextInt(4);
        System.out.println(i1);
//并发随机数用，很快
        double j = ThreadLocalRandom.current().nextDouble(8,9);
        System.out.println(j);
    }
}
