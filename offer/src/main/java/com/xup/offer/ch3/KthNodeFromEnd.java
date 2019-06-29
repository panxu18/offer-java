package com.xup.offer.ch3;

public class KthNodeFromEnd {
	
	private class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	public ListNode FindKthToTail(ListNode head,int k) {
		if (head == null || k <= 0)
			return null;
		ListNode forntNode = head;
		ListNode tailNode = head;
		int nums = 1;
		while (forntNode.next != null && nums < k) {
			forntNode = forntNode.next;
			nums++;
		}
		if (nums < k)
			return null;
		while (forntNode.next != null) {
			forntNode = forntNode.next;
			tailNode = tailNode.next;
		}
		return tailNode;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
