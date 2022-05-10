package com.sxt.jianjian.IO.file;

import java.io.Serializable;

public class Users implements Serializable {
    private int id;
    private String name;
    private String age;

    public Users(int id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Users() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
