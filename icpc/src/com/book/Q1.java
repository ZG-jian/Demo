package com.book;

public class Q1 {
    public static boolean isCycle(Node head){
        Node p1 = head;
        Node p2 = head;
        while (p2!=null&&p2.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1==p2){
                return true;
            }
        }
        return false;
    }

    private static class Node{
        int data;
        Node next;

         Node(int data) {
            this.data = data;
        }
    }

    /**
     * 求相遇节点并返回
     * @param head
     * @return
     */
    public static Node length(Node head) {
        Node p1 = head;
        Node p2 = head;
        int num = 0;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            int i = 1;
            if (p1 == p2) {
                return p1;
            }
        }
        return null;
    }

    /**
     * 获取环长
     * @param head 传入的相遇节点
     * @return 返回环长
     */
    public static int TLong(Node head){
        //拿到相遇节点
        Node node1 = length(head);
        Node p1 = head;
        Node p2 = head;
        int num = 0;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            num++;
            if (p1 ==p2){
                return num;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(3);
        Node node3 = new Node(7);
        Node node4 = new Node(2);
        Node node5 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;
        System.out.println(isCycle(node1));
//成功
        System.out.println(TLong(node1));
    }
}
