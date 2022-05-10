package com.jianjian.array;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Man[] aa = {
                new Man(18,"小一"),
                new Man(23,"小二"),
                new Man(36,"小三"),
                new Man(49,"小四"),
                new Man(56,"小五")
        };

        for (int i = 0; i <aa.length ; i++) {
            Man man = aa[i];
            System.out.println(man);
        }
        System.out.println("**********");
        for (Man man: aa
             ) {
            System.out.println(man);
        }

        //TestComparable
ComparableTest[] comparableTests = {
                new ComparableTest(1,"张大爷",99),
                new ComparableTest(2,"李大爷",78),
                new ComparableTest(3,"王大妈",69),

};
        Arrays.sort(comparableTests);
        System.out.println(Arrays.toString(comparableTests));


    }
}
