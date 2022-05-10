package com.jian.shiro3;

import org.apache.shiro.crypto.hash.Md5Hash;

public class TestDemo {
    public static void main(String[] args) {

        //使用MD5加密
        Md5Hash md5 =new Md5Hash("1111");
        System.out.println("1111=="+md5);

        //加盐操作
        md5 = new Md5Hash("1111","jian");
        System.out.println("1111=="+md5);

        //迭代的次数
        md5 = new Md5Hash("123","jian",2);
        System.out.println("123=="+md5);
    }
}
