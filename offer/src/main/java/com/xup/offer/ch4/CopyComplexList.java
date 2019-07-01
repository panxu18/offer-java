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
}
