package com.xup.offer.ch4;

import java.util.Stack;

public class StackPushPopOrder {
	private Stack<Integer> stack = new Stack<>();
	
	public boolean IsPopOrder(int [] pushA,int [] popA) {
		if (pushA == null || popA == null)
			return false;
		int index = 0;
		for (int e : popA) {
			/*
			 * 如果是栈顶元素则出栈
			 */
			if (!stack.isEmpty() && e == stack.peek()) {
				stack.pop();
				continue;
			}
			/*
			 * 如果不是栈顶元素则继续入栈
			 */
			while (index < pushA.length && pushA[index] != e)
				stack.push(pushA[index++]);
			if (index >= pushA.length)
				return false;
			index += 1;
		}
        return stack.isEmpty();
    }
	
	public static void main (String[] args) {
		System.out.println(new StackPushPopOrder().IsPopOrder(new int[]{1,2,3,4,5},
				new int[]{4,5,3,2,1}));
	}

}
