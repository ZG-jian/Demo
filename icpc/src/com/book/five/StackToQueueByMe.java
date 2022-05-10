package com.book.five;

import java.util.Stack;

public class StackToQueueByMe {
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
     while (!stackA.isEmpty()){
         stackB.push(stackA.pop());
     }
        return stackB.pop();
    }


    public static void main(String[] args) {
        StackToQueueByMe stackToQueue = new StackToQueueByMe();
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
