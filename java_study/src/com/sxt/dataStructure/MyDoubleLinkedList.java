package com.sxt.dataStructure;

/**
 * 基于双向链表实现元素存取的容器
 * @param <E>
 */
public class MyDoubleLinkedList<E> implements MyList<E> {
    /**
     * 定义双向链表的节点对象
     */
    class  Node<E> {
        E item;//记录元素
        Node<E> prev;//记录前一个节点对象
        Node<E> next;//记录下一个节点对象

        public Node( Node<E> prev,E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }
    private Node<E> head;//记录头节点
    private Node<E> tail;//记录尾节点
    private int size;//记录元素个数

    /**
     * 向双向链表中添加元素的方法
     * @param element
     */
    @Override
    public void add(E element) {
        this.LinkLast(element);
    }

    /**
     * 向双向链表头部添加元素的方法
     */
    private void addFirst(E element){
        this.LinkFirst(element);
    }

    /**
     * 向双向链表尾部添加元素的方法
     */
    private void addLast(E element){
        this.LinkLast(element);
    }

    /**
     *将节点对象添加到双向链表的头部
     */
    private void LinkFirst(E element){

        //获取头节点
        Node<E> head = this.head;
        //创建一个新的节点,并完成与头节点的挂接
        Node node = new Node(null,element,head);
        this.head = node;
        if (head==null){
            //如果没有头节点，即没有节点，则创建的节点也为尾节点
            this.tail = node;
        }else {
            //完成头节点和新节点的挂接
//            this.head.prev = node;这样错了，因为是将节点对象添加到头节点，已经把当前节点作为头节点了
            //只差修改原头节点的指针了
            head.prev = node;
        }
        this.size++;
    }


    /**
     * 将节点对象添加到双向链表的尾部
     */
    private  void LinkLast(E element){
        //获取尾节点
        Node<E> t = this.tail;
        //创建节点对象
        Node<E> node = new Node<>(t,element,null);//这里已经完成新节点和尾节点的挂接了
        //将新节点定义为尾节点
        this.tail = node;

        if (t == null){//不能拿this.tail来判断了，因为已经指向新节点了，所以拿t判断
            this.head = node;
        }else {
            t.next =node;//完成尾节点与新节点的挂接
        }
        this.size++;

    }

    /**
     * 根据指定位置获取元素
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        Node<E> node = this.getNode(index);
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
     * 根据位置获取节点对象
     */
    //这个跟源码的node几乎一模一样
private  Node getNode(int index){
    //判断当前位置距离头或者尾哪个节点近
    if (index<(this.size)>>1){
        Node<E> node = this.head;
        for (int i = 0; i <index ; i++) {
            node = node.next;
        }
        return node;
    }else {
        Node<E> node = this.tail;
        for (int i = this.size-1; i >index ; i--) {
            node = node.prev;
        }
        return node;
    }

}

    /**
     * 返回元素的个数
     * @return
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * 根据指定位置删除元素
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        //对index进行合法校验
        checkIndex(index);
        //根据指定位置获取节点对象
        Node<E> node = this.getNode(index);
        //获取节点对象中的元素
        E item = node.item;
        //判断当前节点是否为头节点
        if (node.prev == null){
            //如果当前节点为头节点，则让头节点为当前节点的直接后驱节点
            this.head = node.next;
        }else {
            //完成当前节点的直接前驱节点和直接后驱节点的挂接
            node.prev.next = node.next;
        }
        //判断当前节点是否为尾节点
        if (node.next==null){
            //如果当前节点为尾节点，则让尾节点为当前节点的直接前驱节点
            this.tail = node.prev;
        }else {
            //完成当前节点的直接后驱节点与直接前驱节点的挂接
            node.next.prev = node.prev;
        }
        node.prev = null;//当前节点断掉与直接前驱节点的连接
        node.next = null;//当前节点断掉与直接后驱节点的连接
        node.item = null;

//记录元素个数
        size--;
        return item;
    }

    /**
     *第一次打完时，有一个问题，遍历时aacd之类的刚开始以为是添加方法问题，对着源码对了两边，给每一个Node引用都
     * 添加了泛型，但是没有解决问题，add方法和调用的往尾部添加方法都没问题，那么问题一个就是在根据索引返回元素
     * 的地方了，再拿着getNode方法和源码的node方法对照，发现是逆序查找返回的for循环里的设置初值没有-1；因为
     * 索引是比元素数量少1的，就产生了问题
     * @param args
     */
    public static void main(String[] args) {
        MyList<String> myDoubleLinkedList = new MyDoubleLinkedList<>();
        myDoubleLinkedList.add("a");
        myDoubleLinkedList.add("b");
        myDoubleLinkedList.add("c");
        myDoubleLinkedList.add("d");

        System.out.println(myDoubleLinkedList.size());
        for (int i = 0; i <myDoubleLinkedList.size() ; i++) {
            System.out.println(myDoubleLinkedList.get(i));
        }
        System.out.println("-------头节点和尾节点添加-----");
        //因为头节点和尾节点添加不是实现接口的方法，所以修饰不能使用接口修饰
        MyDoubleLinkedList<String> list = new MyDoubleLinkedList<>();
        list.add("a");
        list.addFirst("A");
        list.addLast("B");
        list.addFirst("C");
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));

        }
    }
}
