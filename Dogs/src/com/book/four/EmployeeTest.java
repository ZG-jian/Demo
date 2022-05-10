package com.book.four;
import java.util.*;


public class EmployeeTest {
    private String name;
    private double salary;

    public EmployeeTest(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeTest{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    EmployeeTest mate = new EmployeeTest("Tom",3500.0);
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        System.out.println("name = " + name);
        

    }

}
