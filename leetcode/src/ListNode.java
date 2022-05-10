
public class ListNode {
    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode vNode = new ListNode(0);
        vNode.next = head;
        ListNode prev = vNode;
        //在第一轮就是头节点不为空并且有下一个结点
        while (prev.next != null && prev.next.next != null) {
            //先暂存第二个当前结点的下一个结点，不然第二步会丢失链表
            ListNode temp = head.next.next;

            prev.next = head.next;//第一步
            head.next.next = head;//第二步
            head.next = temp;//第三步
            //下两个，进一操作
            prev = head;
            head = head.next;
        }
        return vNode.next;//返回头结点
    }


    public static void main(String[] args) {
        ListNode listNode4 = new ListNode(4, null);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode = new ListNode(1, listNode2);

        System.out.println(new Solution().swapPairs(listNode));
    }
}
