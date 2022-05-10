package com.sxt.Collection.List;

import java.util.Stack;
//对栈的操作永远是从栈顶开始
public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
//将元素添加到栈容器中
        stack.push("aaa");
        stack.push("bbb");
        stack.push("ccc");
//查看栈顶对象，不删除
        System.out.println(stack.peek());
        //删除并返回栈顶对象
        System.out.println(stack.pop());
        System.out.println(stack.peek());

        //判断是否为空
        System.out.println(stack.empty());
        stack.push("ccc");
        //查找元素位置，无返回-1， 从栈顶开始找，所以aaa是是三
        System.out.println(stack.search("aaa"));

    }
}
