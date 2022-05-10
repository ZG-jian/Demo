package com.jianjian.zuhe;
public class TestZuHe{
public static void main(String[ ] args) {
        Student s = new Student("高淇",172,"Java");
        s.person.rest(); //s.rest();

        }
        }
class Person {
    String name;
    int height;
    public void rest(){
        System.out.println("休息一会！");
    }
}
class Student /*extends Person*/ {
    Person person = new Person();
    String major; //专业

    public Student(String name, int height, String major) {
//天然拥有父类的属性
        this.person.name = name; //this.name = name;
        this.person.height = height; //this.height = height;
        this.person.rest();
        this.major = major;
    }
}
