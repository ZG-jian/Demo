package com.sxt.dataStructure;

/**
 * 基于链表结构存取元素的方法api定义
 * 创建链表接口
 * @param <E>
 */
public interface MyList<E> {
    void add(E element);
    E get(int index);
    int size();
    E remove(int index);

}
