package com.jian;

import java.util.Scanner;

/**
 * 数据校验类
 * 输入并验证各个输入数据并返回
 * 效验也大多都一样
 */
//其实方法里的Scanner是可以在类里创建的，但为什么没呢？
//因为成员变量的声生命周期是长于局部变量的，占用内存空间
public class TelNotRegex {
    /**
     * 对菜单输入选项的验证
     * 让这个方法完成对所有输入的菜单项的效验
     * @param min
     * @param max
     * @return
     */
    public int menuItemValidate (int min, int max ){
        //定义验证菜单项的正则表达式
        String regex = "[1-9]{1}";
        //创建键盘输入对象
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入正确的数字，最小是："+min+"\t最大是："+max);
            String input = scanner.nextLine();
            if (input.matches(regex)){
                int inputNum = Integer.parseInt(input);
                if (inputNum>=min&&inputNum<=max){
                    return inputNum;
                }else {
                    System.out.println("您输入的菜单项不符，请重新输入！");
                }
            }else {
                System.out.println("输入的数字错误，请检查！");
            }
        }
    }

    /**
     * 对用户输入姓名的验证
     * @return
     */
    public String nameValidate (){
        String regex = "[a-zA-Z]{1,10}";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入姓名：格式为1-10个大写或者小写字母。");
            String input = scanner.nextLine();
            if (input.matches(regex)){
                return  input;
            }else {
                System.out.println("您当前输入的姓名有误，请重新输入！");
            }
        }
    }

    /**
     * 对用户输入年龄的验证
     * 年龄要求格式10-99之间
     * @return
     */
    public String ageValidate (){
        //对年龄验证的正则表达式
        String regex = "[1-9]{1}[0-9]{1}";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入年龄：格式为10-99的数字");
            String input = scanner.nextLine();
            if (input.matches(regex)){
                return  input;
            }else {
                System.out.println("您当前输入的年龄有误，请重新输入！");
            }
        }
    }

    /**
     * 对用户输入性别的验证
     * 男性：m或M    女性：f或F
     * @return
     */
   public String sexValidate (){
       //对性别进行效验的正则表达式
       String regex = "[m|M|f|F]{1}";
       Scanner scanner = new Scanner(System.in);
       while (true){
           System.out.println("请输入性别：格式为(男 m or M)  (女 f or F)");
           String input = scanner.nextLine();
           if (input.matches(regex)){
               return  input;
           }else {
               System.out.println("您当前输入的性别有误，请重新输入！");
           }
       }

   }

    /**
     * 对用户输入电话号码的验证
     * 电话号码要求：允许带有区号的座机号，允许手机号
     * @return
     */
    public String telNumValidate (){
        //对电话号码效验的正则表达式
        String regex = "(\\d{3,4}-\\d{7,8})|([1]{1}\\d{10})";
        //创建键盘输入对象
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入电话号码：可以是座机号或手机号");
            String input = scanner.nextLine();
            if (input.matches(regex)){
                return  input;
            }else {
                System.out.println("您当前输入的电话号码有误，请重新输入！");
            }
        }
    }

    /**
     * 对用户输入地址的验证
     * 地址格式要求：字母或者数字，长度1-50
     * @return
     */
    public String addressValidate (){
        //对地址效验的正则表达式
        String regex = "\\w{1,50}";
        //创建键盘输入对象
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入地址格式：格式为字母或者数字，长度1-50");
            String input = scanner.nextLine();
            if (input.matches(regex)){
                return  input;
            }else {
                System.out.println("您当前输入的地址有误，请重新输入！");
            }
        }
    }

//测试验证类中的验证方法
    public static void main(String[] args) {
        TelNotRegex regex = new TelNotRegex();
      /*  //对菜单输入选项的验证方法的测试
        int menuItem = regex.menuItemValidate(1, 6);
        System.out.println(menuItem);*/

/*     //对用户输入姓名的验证方法的测试
        String name = regex.nameValidate();
        System.out.println(name);*/

  /*      //对年龄验证方法的测试
        String age = regex.ageValidate();
        System.out.println(age);*/

    /*    //对性别验证方法的测试
        String sex = regex.sexValidate();
        System.out.println(sex);*/

   /*     //对电话号码验证方法的测试
        String TelNum = regex.telNumValidate();
        System.out.println(TelNum);*/
        //对地址验证方法的测试
        String address = regex.addressValidate();
        System.out.println(address);
    }
}
