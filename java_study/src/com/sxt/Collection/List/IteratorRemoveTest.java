package com.sxt.Collection.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//迭代器迭代是可以删除元素，而用含有迭代因子的for循环直接删除元素就会有问题

//foreach和for型迭代器循环里是不允许添加元素的，带迭代因子的可以添加，但是是死循环

//尽量别在迭代容器元素的时候删除元素
public class IteratorRemoveTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        int flag = -1;//假设修正法
        for (int i = 0; i <list.size() ; i++) {
            //删除2位置
            //加个判断后就没问题了
//            if ("c".equals(list.get(i))){
////                list.remove(2);
////            }
//            list.add("lll");//死循环添加打印
           //假设修正法删
            if ("c".equals(list.get(i))){
               flag = i;
           }
            if (flag>-1){
                list.remove(flag);
            }

            System.out.println(list.get(i));
        }
        /**这是结果,因为删除c后d又以往前移动了到了2位置然后又把d删除
         * a
         * b
         */
        System.out.println("-------增强for循环删除，也可------------");
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        for (String str:list1
             ) {
//            list1.add("dddd");//foreach底层也是迭代器实现的，不能添加
            if ("c".equals(str)){
                list1.remove(2);
            }
        }
        for (String str:list1
        ) {
            System.out.println(str);
        }
        System.out.println("----------------------------");
        List<String> list2 = new ArrayList<>();
        list2.add("aa");
        list2.add("bb");
        list2.add("cc");
        list2.add("dd");
        Iterator<String> iterator = list2.iterator();
        while (iterator.hasNext()){
            if ("cc".equals(iterator.next())){
                list2.remove(2);
            }
        }
        System.out.println("------查看迭代器删除-----");
        for (Iterator<String> it = list2.iterator();it.hasNext();){
            System.out.println(it.next());
        }
    }
}
