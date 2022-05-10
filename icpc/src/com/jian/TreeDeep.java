package com.jian;


public class TreeDeep {
    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node6 = new TreeNode(6, node7, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, node6, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);
        System.out.println(minDepth(node1));
    }

    /**
     * 深度优先
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        if (root == null) {//没有节点返回0
            return 0;
        }
        if (root.leftChild == null && root.rightChild == null) {//判断叶子节点
            return 1;
        }
        int min = Integer.MAX_VALUE;
        if (root.leftChild != null) {//左边节点不为空，算出深度
            min = Math.min(minDepth(root.leftChild), min);
        }
        if (root.rightChild != null) {//右边边节点不为空，算出深度
            min = Math.min(minDepth(root.rightChild), min);
        }
        return min + 1;
    }

    /**
     * 广度优先
     * @param root
     * @return
     */
    public static int minDepth2(TreeNode root) {

        return 1;
    }
    /**
     * 二叉树节点
     */
    static class TreeNode {
        int val;
        TreeNode leftChild;
        TreeNode rightChild;

        public TreeNode(int val, TreeNode leftChild, TreeNode rightChild) {
            this.val = val;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }


}
