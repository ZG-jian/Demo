package com.jianjian;
//父类
public abstract class Animals {
    private int age;
    private String name;
    private String  varieties;
    private String food;

    public void setAge(int age){
        if (age < 0 || age > 100){
            System.out.println("您的输入有误，已经清零");
        }else {
            this.age = age;
        }

    }

    public String getName() {
        return name;
    }
    //无参构造器
    public Animals(){

    }
    //构造方法
    public Animals(int age, String name, String varieties, String food) {
        this.age = age;
        this.name = name;
        this.varieties = varieties;
        this.food = food;
        System.out.println("Animals的构造方法里的输出");
    }

    public Animals(int age, String name) {
        this.age = age;
        this.name = name;
    }
    //setter and getter

    public void setName(String name) {
        this.name = name;
    }

    public String getVarieties() {
        return varieties;
    }

    public void setVarieties(String varieties) {
        this.varieties = varieties;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getAge(){
        return this.age;
    }
    //小区名，只给了一个getter，不能修改


    @Override
    public String toString() {
        return "Animals{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", varieties='" + varieties + '\'' +
                ", food='" + food + '\'' +
                '}';
    }

    public static String getPlot(){
        return plot;
    }
    //静态的，用类名点就行，对象没了都行
    private static String plot = "NanG";
    public void sleep(){
        System.out.println(this.name + "睡觉了");
    }
    public void eat(){
        System.out.println(this.name + "吃" + this.food);
    }
    public static void Injection(){
        System.out.println("所有的动物都要打针");
    }
    //抽象方法
    public abstract void braking();
}
