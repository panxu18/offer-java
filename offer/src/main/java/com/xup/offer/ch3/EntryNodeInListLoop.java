package com.xup.offer.ch3;

public class EntryNodeInListLoop {

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	/**
	 * 1、找到环中的节点
	 * 2、计算环中节点个数
	 * @param pHead
	 * @return
	 */
	public ListNode entryNodeOfLoop(ListNode pHead) {
		if (pHead == null)
			return null;
		ListNode p1 = pHead;
		ListNode p2 = pHead;
		// 将p1前进2步,p2前进一步
		do {
			if (p1.next != null && p1.next.next != null) {
				p1 = p1.next.next;
				p2 = p2.next;
			} else
				return null;
		} while (p1 != p2);
		// 计算环中节点个数
		int count = 0;
		do {
			p1 = p1.next;
			count++;
		} while (p1 != p2);
		p1 = pHead;
		p2 = pHead;
		// p1向前k步
		for (int i = 0; i < count; i++)
			p1 = p1.next;
		// 如果链表是一个环直接返回，否则循环直到p1==p2
		while (p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
}
