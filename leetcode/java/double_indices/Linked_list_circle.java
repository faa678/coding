package com.faa.leetcode;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
 }

public class Linked_list_circle {

    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode move1 = head, move2 = head.next;
        while(move1 != null && move2 != null && move2.next != null) {
            if(move1 == move2) return true;
            else {
                move1 = move1.next;
                move2 = move2.next.next;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = a;
        System.out.println(new Linked_list_circle().hasCycle(a));
    }

}
