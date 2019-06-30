package com.xup.offer.ch4;

import java.util.Stack;

public class MinInStack {
	
	private Stack<Integer> statck = new Stack<>();
	private Stack<Integer> minStack = new Stack<>();
	
	public void push(int node) {
		if (statck.isEmpty()) {
			statck.push(node);
			minStack.push(node);
		} else {
			statck.push(node);
			minStack.push(node < minStack.peek() ? node : minStack.peek());
		}
	}

	public void pop() {
		statck.pop();
		minStack.pop();
	}

	public int top() {
		return statck.peek();
	}

	public int min() {
		return minStack.peek();
	}

}
