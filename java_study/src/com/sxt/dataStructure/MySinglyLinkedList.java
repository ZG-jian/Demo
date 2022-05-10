package com.sxt.dataStructure;

public class MySinglyLinkedList<E> implements MyList<E> {

    /**
     * 定义单向链表中的节点对象
     * 单向链表中的节点类
     */
    class Node<E>{
        private E item;//存储元素
        private Node next;//存储下一个成员变量的地址

        public Node(E item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node head;//存放列表的头节点
    private int size;//记录元素个数
    /**
     * 向链表中添加元素
     * @param element

     */
    @Override
    public void add(E element) {
        //创建节点
        Node node = new Node(element,null);
        //这里说明，这个node是我要添加的新节点，添加到尾部，所以构造方法给的尾节点为空

        //找到尾节点
        Node tail = getTail();
        //节点的挂接

//查找尾节点返回后，如果找的的尾节点为空，说明只有一个节点，那就是头节点，把找到的头节点作为头节点
        if (tail == null){
            this.head = node;
        }else {
            //这个节点不是头节点，让尾节点的next指向添加（或者创建）的节点，形成挂接
            //这样就把当前节点挂到了整个单向链表的最后一个节点上
        tail.next = node;//尾节点的下一个节点是当前节点
        }

        //记录元素的个数
        this.size++;
    }
    /**
     * 找尾节点
     */
    private Node getTail(){
        //头节点是否存在
       if (this.head==null){
           return  null;
       }
        //查找尾节点,从头节点开始往下找,利用循环
        Node node = this.head;//这里是为什么呢？很简单，头节点不能动了，创建一个新的指针来移动寻找尾节点
       while (true){
           if (node.next == null)break;//找到尾节点，退出循环
           node = node.next;//一个节点一个节点往下找,
       }
       return node;//返回找到的尾节点

    }

    /**
     * 根据元素位置获取元素
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        //效验Index的合法性
        this.checkIndex(index);
        //根据位置获取指定节点
        Node<E> node = this.getNode(index);
        //将节点的中的元素返回
        return node.item;
    }
    /**
     * 对Index进行效验
     */
    private void checkIndex(int index){
        if (!(index>=0&&index<size)){
            throw new IndexOutOfBoundsException("Index:"+index+"Size:"+this.size);
        }
    }
    /**
     * 根据位置获取节点
     */
    private Node getNode(int index){
        Node<E> node = this.head;
        for (int i = 0; i <index ; i++) {
            node = node.next;
        }
        return  node;
    }

    /**
     * 获取元素的个数
     * @return
     */
    @Override
    public int size() {
        return this.size;
    }


    /**
     * 根据元素的位置删除元素
     * @return
     */
    @Override
    public E remove(int index) {
        //效验Index的合法性
        this.checkIndex(index);
        //根据节点位置找到节点对象
        Node<E> node = this.getNode(index);
        //获取该节点对象中的元素
        E item = node.item;
        //将该节点对象从单向链表中删除
           //判断当前节点是否为头节点
        if (this.head==node){
            this.head = node.next;
        }else {
            //当前节点不是头节点，找到当前节点的前一个节点，让他指向当前节点的下一个节点
            Node temp = this.head;//老办法，不动头节点，用一个新指针去操作
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            //            temp = getNode(index-1);//或者换成这一句就行了，一个意思，测试可行
            temp.next = node.next;
        }
        node.next = null;
        //记录元素个数
        this.size--;
        //将该元素返回
        return item;
    }


    public static void main(String[] args) {

        MySinglyLinkedList<String> mySinglyLinkedList = new MySinglyLinkedList<>();
        mySinglyLinkedList.add("a");
        mySinglyLinkedList.add("b");
        mySinglyLinkedList.add("c");
        mySinglyLinkedList.add("d");
        for (int i = 0; i <mySinglyLinkedList.size ; i++) {
            System.out.println(mySinglyLinkedList.get(i));
        }
        System.out.println("-------删除位置为1的元素-------");
        mySinglyLinkedList.remove(1);
        for (int i = 0; i <mySinglyLinkedList.size ; i++) {
            System.out.println(mySinglyLinkedList.get(i));
        }
        System.out.println("元素的个数为："+mySinglyLinkedList.size);
        System.out.println(mySinglyLinkedList.get(0));
    }
}
