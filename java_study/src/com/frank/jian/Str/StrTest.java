package com.frank.jian.Str;

import org.junit.Test;

public class StrTest {


    @Test
    public void TestCharAt() {
        //
        //返回char指定索引处的值
        String s1 = "I love you ,baby!";
        System.out.println(s1.charAt(7));
    }

    //chars、codePoints​待测试
    @Test
    public void TestCodePointAt() {
        //返回指定索引处的字符（Unicode代码点）。
        String s1 = "I love you ,baby!";
        System.out.println(s1.codePointAt(7));
        //y的&#121;
    }

    @Test
    public void TestCompareTo() {
        //每个位置的字母比按顺序比，返回s1比s2大多少个（可多-1个）
        //按字典顺序比较两个字符串
        //没有忽略大小写
        //	compareToIgnoreCase忽略大小写
        String s1 = "a";
        String s2 = "A";
        System.out.println(s1.compareTo(s2));
    }

    @Test
    public void TestEndsWith() {
        //测试此字符串是否以指定的后缀结尾。
        String s1 = "I love you";
        System.out.println(s1.endsWith("you"));
    }

    @Test
    //boolean startsWith(String prefix) 如果字符串以 prefix 开始，则返回 true。
    public void TestStartWith() {
        String str1 = "I Love You!";
        System.out.println(str1.startsWith("I"));
    }

    @Test
    public void TestConcat() {
        String s1 = "What the ";
        //将指定的字符串连接到该字符串的末尾。
        System.out.println(s1.concat("fuck!"));
        //完事了没变？
        System.out.println(s1);

    }

    @Test
    public void Contains() {
        String s1 = "I love you";
        //当且仅当此字符串包含指定的char值序列时，才返回true。
        System.out.println(s1.contains("love"));
        System.out.println(s1.contains("lover"));
        System.out.println(s1.length());


    }

    @Test
    public void UpperAndLower() {
        String s1 = "I love you".toUpperCase();
        String s2 = "I LOVE YOU".toLowerCase();
        System.out.println(s1 + "4654      " + s2);

    }

    @Test
    public void testReplace() {
        String str1 = "abcdbcdbcd".replace('d', 'D');
        String str2 = "I Love You!".replace("Love", "Fuck");
        System.out.println(str1);
        System.out.println(str2);
    }

    @Test
    public void TestSubstring() {
        //返回一个新字符串，该串包含从原始字符串 beginIndex 到串
        //尾。  截取一样
        String string = "I Love You!";
        System.out.println(string.substring(7));//7到后面
        System.out.println(string.substring(2, 6));//2-7
    }
    @Test
    public void TestTrim(){
        //返回一个新字符串，该串删除了原始字符串头部和尾部的空
        //格。
        String str1 = "  ** a b **  ";
        String str2 = str1.trim();
        System.out.println(str2);
        System.out.println(str1.replace(" ", ""));
        System.out.println(str1);

    }
    //String是不可变字符序列。所有的替换、截取字符串、去空格、转换大小写等都是生成了新字符串

    //未测	contentEquals
    //将此字符串与指定的比较CharSequence（字符序列）。
//    @Test
//    public void ContentEquals(){
//        String s1 = "I love you";
//        System.out.println(s1.contentEquals("love"));
//    }
//valueOf不会用


}
