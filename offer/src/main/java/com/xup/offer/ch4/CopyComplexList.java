package com.xup.offer.ch4;

import java.util.HashMap;
import java.util.Map;

public class CopyComplexList {
	
	
	public class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
	
	public RandomListNode Clone(RandomListNode pHead) {
//		return CloneWithMap(pHead);
		return CloneWithoutMap(pHead);
	}

	/*
	 * 空间复杂度O(n)，时间复杂度O(n)
	 */
	private RandomListNode CloneWithMap(RandomListNode pHead) {
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode newHead = null;
		RandomListNode oldNode = pHead;
		RandomListNode oldPreNode = null;
		RandomListNode newNode = null;
		RandomListNode newPreNode = null;
		/*
		 * 遍历链表将节点和对应的新节点放入map
		 */
		while (oldNode != null) {
			newNode = new RandomListNode(oldNode.label);
			map.put(oldNode, newNode);
			if (newPreNode != null)
				newPreNode.next = newNode;
			newPreNode = newNode;
			oldPreNode = oldNode;
			oldNode = oldNode.next;
		}
		/*
		 * 遍历链表设置随机链
		 */
		oldNode = pHead;
		while (oldNode != null) {
			if (oldNode.random == null)
				map.get(oldNode).random = null;
			else {
				map.get(oldNode).random = map.get(oldNode.random);
			}
			oldNode = oldNode.next;
		}
		/*
		 * 返回头结点
		 */
		return map.get(pHead);
	}
	
	/*
	 * 空间复杂度O(1)时间复杂度O(n)
	 */
	private RandomListNode CloneWithoutMap(RandomListNode pHead) {
		RandomListNode pNode = pHead;
		RandomListNode temp = null;
		/*
		 * 复制节点并插入next链中
		 */
		while (pNode != null) {
			temp = pNode.next;
			pNode.next = new RandomListNode(pNode.label);
			pNode.next.next = temp;
			pNode = temp;
		}
		/*
		 * 复杂random链
		 */
		pNode = pHead;
		while (pNode != null) {
			if (pNode.random != null)
				pNode.next.random = pNode.random.next;
			pNode = pNode.next.next;
		}
		/*
		 * 拆分链表
		 */
		pNode = pHead;
		RandomListNode newHead = null;
		while (pNode != null) {
			if (newHead == null) {
				newHead = pNode.next;
				temp = newHead;
			} else {
				temp.next = pNode.next;
				temp = temp.next;
			}
			pNode.next = temp.next;
			pNode = pNode.next;
		}
		return newHead;
	}
	
	public static void main(String[] args) {
		CopyComplexList complexList = new CopyComplexList();
		RandomListNode a = complexList.new RandomListNode(1);
		RandomListNode b = complexList.new RandomListNode(2);
		RandomListNode c = complexList.new RandomListNode(3);
		RandomListNode d = complexList.new RandomListNode(4);
		RandomListNode e = complexList.new RandomListNode(5);
		a.next = b;
		a.random = c;
		b.next = c;
		b.random = e;
		c.next = d;
		d.next = e;
		d.random = b;
		RandomListNode head = complexList.Clone(a);
		RandomListNode tempH = head;
		RandomListNode tempA = a;
		while (head != null && a != null) {
			System.out.println("copy: " + head + " origin: " + a + " isEqual: " + (a == head));
			head = head.next;
			a = a.next;
		}
		head = tempH;
		a = tempA;
		while (head != null && a != null) {
			System.out.println("copy: " + head.random + " origin: " + a.random + " isEqual: " + (a.random == head.random));
			head = head.next;
			a = a.next;
		}
		
	}
	
}
