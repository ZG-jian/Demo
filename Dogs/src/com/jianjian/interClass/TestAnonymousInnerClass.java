package com.jianjian.interClass;

public class TestAnonymousInnerClass {

    public  void Test(A a){
        a.run();
    }
    interface A{
        void run();
    }

    class AA implements A{

        @Override
        public void run() {
            System.out.println("接口的实现");
        }
    }
    public static void main(String[] args) {
        TestAnonymousInnerClass oh = new TestAnonymousInnerClass();
        oh.Test(new A() {
            @Override
            public void run() {
                System.out.println("匿名内部类的测试");
            }
        });
    }


}
