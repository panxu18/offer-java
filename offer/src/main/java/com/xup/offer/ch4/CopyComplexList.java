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
		RandomListNode newHead = null;
		RandomListNode oldNode = pHead;
		RandomListNode oldPreNode = null;
		RandomListNode newNode = null;
		RandomListNode newPreNode = null;
		/*
		 * 遍历链表构建next链
		 */
		while (oldNode != null) {
			newNode = new RandomListNode(oldNode.label);
			if (newPreNode == null)
				newHead = newNode;
			else
				newPreNode.next = newNode;
			newPreNode = newNode;
			oldPreNode = oldNode;
			oldNode = oldNode.next;
			// 利用原节点的next指向新复制的节点，新节点的random指向原节点，
			// 从而不需要利用map保存两个节点的对应关系
			oldPreNode.next = newNode;
			newNode.random = oldPreNode;
		}
		/*
		 * 遍历复制的链表，设置random链
		 */
		 newNode = newHead;
		 while (newNode != null) {
			 // 新节点对应的原节点
			 oldNode = newNode.random; 
			 /*
			  * 设置新节点的random链
			  */
			 if (oldNode.random == null)
				 newNode.random = null;
			 else
				 newNode.random = oldNode.random.next;
			 /*
			  *  恢复原节点的next链
			  */
			 if (newNode.next != null)
				 oldNode.next = newNode.next.random;
			 else
				 oldNode.next = null;
			 // 移动指针
			 newNode = newNode.next;
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
