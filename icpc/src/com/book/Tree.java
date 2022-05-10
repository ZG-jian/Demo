package com.book;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        TreeNode treeNode = createBinaryTree(inputList);
        System.out.println("前序遍历:");
        preOrderTraversal(treeNode);

    }

    /**
     * 构建二叉树
     *
     * @param inputList 输入的序列
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;//如果输入的序列是空的或者是null直接返回null
        }
        Integer data = inputList.removeFirst();
        //这里的判断很关键，如果元素是空，则不再进一步递归
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;//把创建的节点返回
    }

    /**
     * 二叉树节点
     */
    private static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    /**
     * 二叉树前序遍历
     *
     * @param node 二叉树节点
     */
    public static void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }

    /**
     * 二叉树层序遍历
     * @param root 二叉树根节点
     */
    public static void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.println(node.data);
            if (node.leftChild!=null){
                queue.offer(node.leftChild);
            }
            if (node.rightChild!=null){
                queue.offer(node.rightChild);
            }
        }
    }
}
