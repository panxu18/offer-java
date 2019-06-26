package com.xup.offer.ch2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;


class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

public class PrintListInReversedOrder {
	
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		/*
		 * 空节点检查
		 * Effective java Item 54, 返回空集合不应该返回null。
		 */
		if (listNode == null) 
			Collections.emptyList();
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		Stack<Integer> stack  = new Stack<Integer>();
		/*
		 * 元素入栈
		 */
		while (listNode != null) {
			stack.push(listNode.val);
			listNode = listNode.next;
		}
		/*
		 * 元素出栈
		 */
		while (!stack.isEmpty()) {
			array.add(stack.pop());
		}
		return array;
	}

	public static void main(String[] args) {
		
	}

}
