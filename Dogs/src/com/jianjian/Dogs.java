package com.jianjian;
//子类
public class Dogs extends Animals {

    public Dogs() {
    }

    public Dogs(int age, String name, String varieties, String food) {
        super(age, name, varieties, food);
        System.out.println("Dogs里的构造器里的输出");
    }

    @Override
    public String toString() {
        return "Dogs{" +
                "age=" + getAge() +
                ", name='" + getName() + '\'' +
                ", varieties='" +getVarieties()  + '\'' +
                ", food='" + getFood() + '\'' +
                '}';
    }

    public Dogs(int age, String name) {
        super(age, name);
    }

    //重写
    @Override
    public void braking() {
//        super.braking();
        System.out.println("汪汪汪~~~~~~");
    }
    //toString的重写


    //添加final修饰后断子绝孙了，不能被子类重写或者本类修改，但可以用
    public final boolean Guide() {
        return false;
    }
}
