package com.sxt.dataStructure;
/*
基于二叉树结构实现元素排序处理的排序器
 */
//上限限定
public class BinaryTreeSort<E extends Integer> {
    /**
     * 定义节点类
     */
    class Node<E extends Integer>{
        private E item;//存放元素
        private Node left;//存放左子树位置
        private Node right;//存放右子树位置

        public Node(E item) {
            this.item = item;
        }

        /**
         * 添加节点
         */
        private void addNode(Node node){
            //完成新节点中的元素与当前节点中的元素的判断
            //如果新节点中的元素小于当前节点中的元素，那么新节点放到当前节点的左子树中
            if (node.item.intValue()<this.item.intValue()){
                if (this.left==null)
                    this.left = node;
                else
                    this.left.addNode(node);
            }
            else {
                //如果新节点中的元素大于当前节点中的元素，那么新节点放到当前节点的右子树中
                if (this.right==null)
                    this.right = node;
                else
                    this.right.addNode(node);
            }
        }
        /**
         * 使用中序遍历二叉树
         */
        public void inorderTraversal(){
            //找到最左侧的那个节点
            if (this.left!=null) this.left.inorderTraversal();
            System.out.println(this.item);
            if (this.right!=null) this.right.inorderTraversal();

        }
    }
    private Node root;
    /**
     * 将元素添加到排序器中
     */
    public void add(E element){

        //实例化节点对象
        Node<E> node = new Node<>(element);
        //判断当前二叉树中是否有根节点，如果没有那么新节点为根节点
        if (this.root == null)
            this.root = node;
        else
            this.root.addNode(node);
    }

    /**
     *对元素进行排序
     */
    public void sort(){
        //判断根节点是否为空
        if (this.root==null) return;
        this.root.inorderTraversal();

    }

    public static void main(String[] args) {
        BinaryTreeSort<Integer> sort = new BinaryTreeSort<>();
        //2、6、7、9、4、8、3
        sort.add(2);
        sort.add(6);
        sort.add(7);
        sort.add(9);
        sort.add(4);
        sort.add(8);
        sort.add(3);
        sort.sort();
    }
}
