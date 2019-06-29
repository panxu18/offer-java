package com.xup.offer.ch3;

public class ReverseList {
	
	private class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	public ListNode ReverseList(ListNode head) {
		if (head == null)
			return null;
		ListNode tempHeadNode = head.next;
		head.next = null;//断开链尾，如果不断开链尾，会导致OJ在遍历翻转的链表时死循环
		ListNode pNode = null;
		while (tempHeadNode != null) {
			pNode = tempHeadNode.next;
			tempHeadNode.next = head;
			head = tempHeadNode;
			tempHeadNode = pNode;
		}
		return head;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
