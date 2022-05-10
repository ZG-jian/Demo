package com.frank.jian.wrapper;

import org.junit.Test;

public class Test01 {

    public void Test() {
        //基本类型转化成Integer对象
        Integer int1 = Integer.valueOf(666);
        System.out.println(int1);
        Integer int2 = new Integer(555);//废弃不推荐使用
        System.out.println(int2);
        //Integer对象转化为int对象；
        int int_1 = int1.intValue();
        System.out.println(int_1);
        //字符串转化为Integer对象
        Integer int3 = Integer.parseInt("1314");
        System.out.println(int3);
    }

    @Test
    public void oye() {
        Test();
    }
@Test
    public void TestCache() {

        Integer int1 = 4000;
        Integer int2 = 4000;
        System.out.println(int1 == int2);
        System.out.println(int1.equals(int2));
    //缓存问题-128~127；
        Integer int3 = 123;
        Integer int4 = 123;
        System.out.println(int3 == int4);
        // 包装类在自动装箱时为了提高效率，对于-128~127 之间的值会进行缓存处理。超过
    //范围后，对象之间不能再使用==进行数值的比较，而是使用 equals 方法。
    }
}
