package com.jianjian;

public class Application {
    public static void main(String[] args) {

        Dogs zhangDog = new Dogs(2,"Jerry","拉布拉多","狗粮");
//        Cats liCat = new Cats(3,"Tom","波斯","小鱼干");

       //抽象类不能创建
//        // Animals animals = new Animals();
//        zhangDog.sleep();
//        liCat.eat();
//        zhangDog.braking();
//        liCat.braking();
//        Labrador Labrador = new Labrador();
//        Labrador.braking();
//        System.out.println(Labrador.Guide());

//接口
//        Chinese chinese = new Chinese();
//        chinese.eat();
//        chinese.sleep();

        //多态
//          向上转型
//        HuaHu huaHu = new HuaMuLan();
//        System.out.println(huaMuLan.age);
//        System.out.println(huaMuLan.name);
//        System.out.println(huaHu.age);
//        System.out.println(huaHu.name);
//        huaHu.fight();
//        huaHu.sayMe();
//        HuaMuLan.sayMe();

        //向下转型
//        HuaMuLan huaMuLan = (HuaMuLan) huaHu;
//        System.out.println(huaMuLan.age);
//        huaMuLan.Dressing();

//        //匿名内部类，一般用到接口上
//        Human chinese = new Human() {
//            @Override
//            public void eat() {
//                System.out.println("中国人吃中国菜");
//            }
//
//            @Override
//            public void sleep() {
//
//            }
//        };
//        chinese.eat();
        //这个时候可以删掉Chinese类

//        Dogs dogs = new Dogs(2,"Jerry");
//        System.out.println(zhangDog);
    }
}
