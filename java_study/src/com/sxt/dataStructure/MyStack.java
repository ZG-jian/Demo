package com.sxt.dataStructure;



import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<E> {
    private Object[] arr;//存放元素的物理结构

    private int stackLength = 4;//数组的默认长度

    private int size;//记录栈容器的元素个数；

    private int index = -1;//操作数组下标位置的指针

    /**
     * 判断容器是否为空
     * @return
     */
    public boolean empty(){
        return this.size==-1;
    }

    /**
     * 获取栈顶元素
     * @return
     */
    public E pop(){
        if (this.size ==-1){
            //假如容器中没有元素则抛出异常
            throw new EmptyStackException();
        }
        //记录元素个数
        this.size--;
        //返回栈顶元素
        return (E) this.arr[index--];
    }

    /**
     * 向栈容器中添加元素

     * @return
     */
    public E push(E item){
        //初始化数组
        this.capacity();
        //向数组中添加元素
        this.arr[++index] = item;
        this.size++;
        return item;
    }


    /**
     * 数组初始化或以1.5倍容量对数组扩容
     */
    private void capacity(){
        //数组初始化
        if (this.arr ==null){
            this.arr = new Object[this.stackLength];
        }
        //以1.5倍对数组扩容
        //除法取模效率低，位移效率高
        if (this.size-(this.stackLength-1)>=0){
            this.stackLength = this.stackLength+(this.stackLength>>1);
            this.arr = Arrays.copyOf(this.arr,this.stackLength);
        }

    }

    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>();
        myStack.push("a");
        myStack.push("b");
        myStack.push("c");
        myStack.push("d");
        myStack.push("e");
        myStack.push("f");
        System.out.println(myStack.size);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());

    }
}
