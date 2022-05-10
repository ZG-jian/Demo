package com.frank.jian.fanxing;

import org.junit.Test;

public class testFanXing {
    @Test
    //测试泛型类
    public void testGeneric(){
        Generic<String> generic = new Generic<>();
        generic.setFlag("简简饱饱");
        String str = generic.getFlag();
        System.out.println(str);

        Generic<Integer> generic1 = new Generic<>();
        generic1.setFlag(666);
        Integer integer = generic1.getFlag();
        System.out.println(integer);
    }
    @Test
    //测试泛型接口实现类
    public void testIGenericImp(){
        IGenericImp iGenericImp = new IGenericImp();
        String str = iGenericImp.getName("简简大帅比");
        System.out.println(str);

//泛型接口修饰对象引用时，在接口上是需要来给定泛型类型的
        IGeneric<String > iGeneric = new IGenericImp();
        String oh = iGeneric.getName("ojbk");
        System.out.println(oh);
    }

    //测试泛型方法
    @Test
    public void TestMethod(){
        MethodGeneric methodGeneric = new MethodGeneric();
        methodGeneric.printName("这里是非静态泛型方法");
        methodGeneric.printName(6666.6666);

        String string =  methodGeneric.ReturnName("这里是非静态返回");
        System.out.println(string);

        MethodGeneric.StaMethod("静态泛型无返回方法方法");
        String str1 = MethodGeneric.StaReMethod("静态泛型有返回");
        System.out.println(str1);

        String[] strs = {"aaa","bbb","ccc"};
        methodGeneric.CanShu(strs);

    }
    //无界通配符测试
    @Test
    //第一遍有病，括号里设了个Generic,然后又Generic什么什么直接错误
    public void TestOther(){
        MethodGeneric methodGeneric = new MethodGeneric();
        Generic<Integer> ge = new Generic<>();
        ge.setFlag(666);
        methodGeneric.showFlag(ge);

        Generic<String> str66 = new Generic<>();
        str66.setFlag("哦哦哦，哦你妈个头");
        methodGeneric.showFlag(str66);

        //下面这里如果在MethodGeneric里的showFlag1方法里extends改为super就会报错，这是下限通配符
        methodGeneric.showFlag1(ge);
//            methodGeneric.showFlag1(str66);这里就因为通配符的上限限定编译错误了
    }
}
