package com.jianjian.polymorphism;

public class Test {
    public static void main(String[] args) {
    Dogs d = new Dogs();
    Animals animals = new Dogs();
//    dogs.shout();


        //多态，父类引用指向子类对象
//        ~Animals a = new Dogs()；
        //Animals a = d;
        animalCry(d);
        animalCry(new Cats());
        System.out.println("*******************");
       // animals为编译类型，Dog 对象才是运行时类型。
        animalCry(animals);//new的是Dogs   Animals animals = new Dogs();
        //不能animals.seeDoor

//        Dogs dogs = new Dogs();
        //向下转型，要强制
        Dogs dogs2 = (Dogs)animals;
//        dogs.seeDoor();
        dogs2.seeDoor();
        Animals animals1 = new Dogs();
        System.out.println("***");
        ((Dogs) animals1).seeDoor();


}
 static void animalCry(Animals a){
        a.shout();
        //多态

    }
    //如果不多态会这样,要重载多个
//    static void animalCry(Dogs a){
//        a.shout();
    /* 如果没有多态，我们这里需要写很多重载的方法。
* 每增加一种动物，就需要重载一种动物的喊叫方法。非常麻烦。
    static void animalCry(Dog d) {
    d.shout();
    }
    static void animalCry(Cat c) {
    c.shout();
    }
    * */
//    }
}
