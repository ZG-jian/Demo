package com.sxt.reflection;

import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws Exception {
        ReflectDemo rd = new ReflectDemo();
        if (args!=null&&args.length>0){
            //获取ReflectDemo的Class对象
            Class aClass = rd.getClass();
            //通过反射获取所有公共方法
            Method[] methods = aClass.getMethods();
            for (String str:args
                 ) {
                for (int i = 0; i <methods.length ; i++) {
                    if (str.equalsIgnoreCase(methods[i].getName())){
                        methods[i].invoke(rd);
                        break;//这里是匹配到了就退出
                        //就是比如给参数213，2匹配fori循环的第二次的方法名，就执行方法
                        //就不执行2与第三个方法的匹配了，这点也很细节
                    }
                }
            }
        }else {
            rd.method1();
            rd.method2();
            rd.method3();
        }
    }
}
