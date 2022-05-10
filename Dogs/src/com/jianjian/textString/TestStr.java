package com.jianjian.textString;

public class TestStr {
    public static void main(String[] args) {
        String str1 = "abcdefghijk";
        String str2 = new String("abcdef");
        String str3 = "ABCDEF";
        String str4 = "def";


        System.out.println(str1 == str2);
        System.out.println(str1);
        System.out.println(str2);
//char charAt(int index) 返回字符串中第 index 个字符
        System.out.println(str1.charAt(3));
        System.out.println(str1.charAt(10));
        System.out.println(str1.charAt(str1.length()-1));

        System.out.println(str1.equals(str2));
        //boolean equalsIgnoreCase 如果字符串与 other 相等（忽略大小写），则返回 true；
        // 否则，(String other) 返回 false
        System.out.println(str2.equalsIgnoreCase(str3));
//int indexOf(String str) 返回从头开始查找第一个子字符串 str 在字符串中的索引位
//置。如果未找到子字符串 str，则返回-1
        System.out.println(str2.indexOf("def"));//"abcdef"  结果3

        System.out.println("abcdefgdefg".lastIndexOf("def"));//从末尾开始查找

//        char oldChar, char newChar)
//        返回一个新串，它是通过用 newChar 替换此字符串中出现的
//        所有 oldChar 而生成的。
        String str5 = "abcdbcd".replace("cd","HELLO");
        System.out.println(str5);

        //) 如果字符串以 prefix 开始，则返回 true。
        //boolean endsWith(String prefix) 如果字符串以 prefix 结尾，则返回 true。
        System.out.println("aaabcddd".startsWith("aaa"));
        System.out.println("aaabcddd".endsWith("aaa"));

        // 返回一个新字符串，该串包含从原始字符串 beginIndex 到串
        //尾
        String str6 = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(str6.substring(7));
        //返回一个新字符串，该串包含从原始字符串 beginIndex 到串
        //尾或 endIndex-1 的所有字符。
        String str7 = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(str6.substring(6, 13));
        //大小写转换
        System.out.println("abcdefg".toUpperCase());
        System.out.println("*********************");
        System.out.println("ABCDEFG".toLowerCase());
//返回一个新字符串，该串删除了原始字符串头部和尾部的空
//格。
        String str8 = "  a b  ";
        String str9 = str8.trim();
        System.out.println(str9);
        //String是不可变字符序列。所有的替换、截取字符串、去空格、转换大小写等都是生成了新字符串


    }
}
