package com.sxt.reflection;

public class Users {
    private  String name;
    public  String sex;
    public int age;

    public Users(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Users(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Users() {
    }

    public Users(String name) {
        this.name = name;
    }
    private Users(int age){
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
    private void FuckPPT(){
        System.out.println("随便的一个私有方法");
    }
}
