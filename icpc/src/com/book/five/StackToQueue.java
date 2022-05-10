package com.book.five;

import java.util.Stack;

public class StackToQueue {
    private Stack<Integer> stackA = new Stack<>();
    private Stack<Integer> stackB = new Stack<>();

    /**
     * 入队操作
     * @param element 入队元素
     */
    public void enQueue(int element){
        stackA.push(element);
    }

    /**
     * 出队操作
     */
    public Integer deQueue(){
        if (stackB.isEmpty()){
                if (stackA.isEmpty()){
                    return null;
                }
            transfer();
        }

        return stackB.pop();
    }

    /**
     * 栈A元素转移到栈B
     */
    public void transfer(){
        while (!stackA.empty()){
            stackB.push(stackA.pop());
        }
    }

    public static void main(String[] args) {
        StackToQueue stackToQueue = new StackToQueue();
        stackToQueue.enQueue(1);
        stackToQueue.enQueue(2);
        stackToQueue.enQueue(3);
        System.out.println(stackToQueue.deQueue());
        System.out.println(stackToQueue.deQueue());
        stackToQueue.enQueue(4);
        System.out.println(stackToQueue.deQueue());
        System.out.println(stackToQueue.deQueue());
    }
}
