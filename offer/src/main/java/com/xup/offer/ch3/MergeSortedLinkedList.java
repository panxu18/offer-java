package com.xup.offer.ch3;

public class MergeSortedLinkedList {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null)
            return null;
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode newHead = null;
        ListNode newTail = newHead;
        if (head1.val < head2.val) {
            newHead = head1;
            newTail = head1;
            head1 = head1.next;

        } else {
            newHead = head2;
            newTail = head2;
            head2 = head2.next;
        }
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                newTail.next = head1;
                newTail = head1;
                head1 = head1.next;
            } else {
                newTail.next = head2;
                newTail = head2;
                head2 = head2.next;
            }
        }
        if (head1 != null)
            newTail.next = head1;
        if (head2 != null)
            newTail.next = head2;
        return newHead;
    }
}
