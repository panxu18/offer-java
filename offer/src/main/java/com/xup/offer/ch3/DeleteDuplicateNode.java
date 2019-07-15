package com.xup.offer.ch3;

public class DeleteDuplicateNode {

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	/**
	 * 
	 * @param pHead
	 * @return
	 */
	public ListNode deleteDuplication(ListNode pHead) {
		if (pHead == null)
			return null;
		ListNode s = new ListNode(-1);
		ListNode pre = s;
		ListNode p = pHead;
		while (p != null) {
			// 指向一个有效节点
			if (p.next != null && p.next.val == p.val) {
				int val = p.val;
				while (p != null && p.val == val)
					p = p.next;
			} else {
				pre.next = p;
				pre = pre.next;
				p = p.next;
			}
		}
		pre.next = null;
		return s.next;
	}
}
