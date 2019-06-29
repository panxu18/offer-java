package com.xup.offer.ch2;

import java.util.Stack;
public class QueueWithTwoStacks {
	
	//队列头
	Stack<Integer> stack1 = new Stack<Integer>();
	//队列尾
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
    	stack2.push(node);
    }
    
    public int pop() {
    	if (stack1.isEmpty()) {
    		while (!stack2.isEmpty()) {
    			stack1.push(stack2.pop());
    		}
    	}
    	if (!stack1.isEmpty())
    		return stack1.pop();
    	return 0;
    }	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
