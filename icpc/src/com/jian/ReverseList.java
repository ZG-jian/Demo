package com.jian;

/**
 * 链表反转
 */
public class ReverseList {

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    //迭代   ---逆转就要反向，所以需要一个prev前节点，看笔记
    public static ListNode iterate(ListNode head){
        ListNode prev = null,curr,next;//curr当前节点，next下一个节点，prev前一个节点
        curr = head;
        while (curr!=null){
            next = curr.next;//保存下一个节点
            curr.next = prev;//将下一个节点的指针指向前一个节点  就是反向
            prev = curr;//把当前节点给prev
            curr = next;//把当前节点改为下一个节点，准备下一次迭代
        }
        return prev;
    }

    //递归
    public static ListNode recursion(ListNode head){
        if (head ==null||head.next==null){
            return head;
        }
        ListNode newHead = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5,null);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        ListNode prev = recursion(node1);
//        ListNode prev = iterate(node1);//迭代测试
        System.out.println(prev);

    }
}
