package com.xup.offer.ch5;

public class CommonNodesInList {
	
	
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if (pHead1 == null || pHead2 == null)
			return null;
		int length1 = 0;
		int length2 = 0;
		ListNode pNode1 = pHead1;
		ListNode pNode2 = pHead2;
		while (pNode1 != null) {
			pNode1 = pNode1.next;
			length1++;
		}
		while (pNode2 != null) {
			pNode2 = pNode2.next;
			length2++;
		}
		if (length1 > length2) {
			for (int i = 0; i < length1 - length2; i++) 
				pHead1 = pHead1.next;
		}
		if (length2 > length1) {
			for (int i = 0; i < length2 - length1; i++) 
				pHead2 = pHead2.next;
		}
		while (pHead1 != null && pHead2 != null && pHead1 != pHead2) {
			pHead1 = pHead1.next;
			pHead2 = pHead2.next;
		}
		if (pHead1 != null)
			return pHead1;
		else
			return null;
    }

}
