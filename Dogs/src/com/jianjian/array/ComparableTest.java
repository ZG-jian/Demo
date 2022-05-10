package com.jianjian.array;
/*
想对某个类的对象之间做比较，就需要实现 Comparable 接口。接口中只有一个方法
compareTo，这个方法定义了对象之间的比较规则。
 */
public class ComparableTest implements Comparable {
    private int Id;
    private String name;
    private int age;

    public ComparableTest(){

    }
    public ComparableTest(int id, String name, int age) {
        Id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(Object o) {
        ComparableTest comparableTest = (ComparableTest) o;
        if ((this.age < comparableTest.age)){
            return -1;

        }
        if (this.age> comparableTest.age){
            return 1;
        }
        return 0;
    }
}
