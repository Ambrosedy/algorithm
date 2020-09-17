/**
 * 题目：翻转链表
 */

 /*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Linklist {
    public ListNode ReverseList(ListNode head) {
        if(head==null||head.next==null)return head;
        
        ListNode resNode = ReverseList(head.next);
        
        head.next.next = head;
        head.next = null;
        
        return resNode;
    }
}