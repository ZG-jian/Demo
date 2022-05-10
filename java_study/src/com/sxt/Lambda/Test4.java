package com.sxt.Lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Test4 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        list.removeIf(ele->ele.equals("b"));//这样是用lambda
//        list.removeIf(Predicate.isEqual("b"));
        list.forEach(System.out::println);
    }
}
