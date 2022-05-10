package com.enumtest;

public class Test {
    @org.junit.Test
    public void tt(){
        Color c1 = Color.Red;
        Color[] values = Color.values();
        for (Color c:values
             ) {
            System.out.println(c);
        }
    }
}
