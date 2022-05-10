package com.sxt.dataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基于树形结构储存元素的容器
 * @param <E>
 */
public class MyTree<E> {
    //map，完成结点间的映射关系，子节点作为key，父节点作为value
    private Map<E,E> map = new HashMap<>();//String-->String
    //map2，完成一个结点与多个结点之间的映射关系，key是当前结点，
    // value是一个List，List放的是当前结点下的所有子结点
    private Map<E,List<E>> map2 = new HashMap<>();//String-->List

    /**
     * 向容器中添加元素
     */
    private void add(E parent,E item){
        //完成单结点之间的映射
        this.map.put(item,parent);
        //完成多结点之间的映射
        List<E> list = this.map2.get(parent);
        //判断当前结点下是否有子结点，如果没有则创建一个新的List
        if (list==null){
            list = new ArrayList<>();
            this.map2.put(parent,list);
        }
        list.add(item);

    }
    /**
     * 获取当前节点的父节点
     */
    private E getParent(E item){
        return this.map.get(item);
    }
    /**
     * 获取当前节点的子节点
     */
    private List<E> getChild(E item){
        return this.map2.get(item);
    }
    /**
     * 获取当前节点的兄弟节点
     */
    private List<E> getBrother(E item){
        //获取当前结点的父结点
        E parent = this.getParent(item);
        //获得当前父结点的所有子结点
        List<E> list = this.getChild(parent);
        List<E> brother = new ArrayList<>();
        if (list!=null){
            brother.addAll(list);
            brother.remove(item);
        }

        return  brother;
    }
    /**
     * 获取当前节点的祖先节点
     */
    private List<E> getForefathers(E item){
        //获取当前结点的父结点
        E parent = this.getParent(item);
        //结束递归的边界条件
        if (parent==null) {
            return new ArrayList<>();
        }
        //递归调用，再次获取当前结点父结点的父结点
        List<E> list  = this.getForefathers(parent);//这句较难理解
        /**
         * 一直递归到结点没有父结点时，返回一个新创建的list，并把它赋给上面List修饰的list并且添加
         * 结点进去，然后不断弹栈添加完所有的父结点
         */
        //将递归到的所有元素添加到返回的list中
        list.add(parent);

        return  list;
    }
    /**
     * 获取当前节点的子孙节点
     */
    private List<E> getGrandChildren(E item){
        //存放子孙结点中的元素
        List<E> list = new ArrayList<>();
        //获取当前结点的子结点
        List<E> child = this.getChild(item);
        //结束递归的边界条件
        if (child == null){
            return list;
        }
        for (int i = 0; i <child.size() ; i++) {
            //获取结点中的元素
            E ele = child.get(i);
            List<E> temp = this.getGrandChildren(ele);
            list.add(ele);
            list.addAll(temp);//取并集，添加当前结点的兄弟结点
        }
        return list;
    }

    public static void main(String[] args) {
        MyTree<String > myTree = new MyTree<>();
        myTree.add("root","生物");
        myTree.add("生物","植物");
        myTree.add("生物","动物");
        myTree.add("生物","菌类");
        myTree.add("动物","脊索动物");
        myTree.add("动物","脊椎动物");
        myTree.add("动物","腔肠动物");
        myTree.add("脊椎动物","哺乳动物");
        myTree.add("脊椎动物","鱼类");
        myTree.add("哺乳动物","猫");
        myTree.add("哺乳动物","牛");
        myTree.add("哺乳动物","人");

        System.out.println("----------获取鱼类的父结点------");
        System.out.println("鱼类的父结点为："+myTree.getParent("鱼类"));
        System.out.println("------获取动物的子结点------");
        List<String> child = myTree.getChild("动物");
        for (int i = 0; i <child.size() ; i++) {
            System.out.println(child.get(i));
        }
        System.out.println("-------获取'脊椎动物'的兄弟结点-----");
        List<String> brother = myTree.getBrother("脊椎动物");
        for (int i = 0; i <brother.size() ; i++) {
            System.out.println(brother.get(i));
        }
        System.out.println("---------获取'人'的祖先结点--------");
        List<String> foreFathers = myTree.getForefathers("人");
        for (int i = 0; i <foreFathers.size() ; i++) {
            System.out.println(foreFathers.get(i));
        }
        System.out.println("----------获取子孙结点---------");
        List<String> grandChild = myTree.getGrandChildren("root");
        for (int i = 0; i <grandChild.size() ; i++) {
            System.out.println(grandChild.get(i));
        }
    }
}
