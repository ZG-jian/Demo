package com.sxt.reflection;

import java.lang.reflect.Field;

/**
 * 操作成员变量
 * Users加一个性别，换一个toString
 * setter和getter也加上吧
 *
 */
public class GetField2 {
    public static void main(String[] args) throws Exception {

        Class aClass = Users.class;
        Field field = aClass.getField("age");
        //对象实例化
        Object obj = aClass.newInstance();
        field.set(obj,18);
        //获取成员变量的值
        System.out.println(field.get(obj));

        System.out.println("---------自己改年龄--------");
        Class aClass1 = Users.class;
        Field field1 = aClass.getField("age");//这里好像可以Users.class.getField
        Users users = new Users("简",18);
        //给获取到age的field1要改哪个对象的age和要改的值
        field1.set(users,77);
        System.out.println(users);
        System.out.println("------------来一波全改-------------");
        Field fieldName = aClass.getDeclaredField("name");
        Field fieldAge = aClass.getDeclaredField("age");
        Field fieldSex  =aClass.getDeclaredField("sex");
        Users usersJ = new Users("简简","男",18);
        System.out.println("修改前："+usersJ);
//        fieldName.set(usersJ,"我要改了你");好像是名字私有了不能改
        fieldSex.set(usersJ,"女");
        fieldAge.set(usersJ,3);
        System.out.println("修改后："+usersJ);
    }
}
