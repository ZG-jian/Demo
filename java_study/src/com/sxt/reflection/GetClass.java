package com.sxt.reflection;

/**
 * 获取class对象的测试
 * 内存里有就不用加载，没有则加载
 */
public class GetClass {
    public static void main(String[] args) throws ClassNotFoundException {
        //通过getClass()方法获取
        Users users = new Users("简",66);
        Class aClass = users.getClass();
        Class aClass1 = users.getClass();
        System.out.println(aClass);
        System.out.println(aClass.getName());
        System.out.println(aClass == aClass1);
        System.out.println("---------通过.class静态属性--------------------");
        Class bClass = Users.class;
        Class bClass1 = Users.class;
        System.out.println(bClass);
        System.out.println(bClass.getName());
        System.out.println("-----------------通过forName()------------------");
        Class cClass = Class.forName("com.sxt.reflection.Users");//这里就不处理异常了
        Class cClass1 = Class.forName("com.sxt.reflection.Users");
        System.out.println(cClass);
        System.out.println(cClass.getName());

    }
}
