package com.sxt.Collection.List;

import java.util.Objects;

public class Users implements Comparable<Users>{
    private String name;
    private int age;

    public Users() {
    }

    public Users(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return age == users.age &&
                Objects.equals(name, users.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Users o) {
        if (this.getAge()>o.getAge()){
            return  1;
        }
        if (this.getAge()== o.getAge()){
            return this.getName().compareTo(o.getName());
        }
        return -1;
    }

}
