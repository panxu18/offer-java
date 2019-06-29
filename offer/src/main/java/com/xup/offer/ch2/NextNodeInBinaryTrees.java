package com.xup.offer.ch2;

public class NextNodeInBinaryTrees {
	
	public TreeNode findNextNode(TreeNode node) {
		if (node == null)
			throw new IllegalArgumentException();
		
		TreeNode next;
		if ((next = node.right) != null) {
			while (node.left != null) {
				next = node.left;
			}
			return next;
		}
		while (node.parent != null) {
			if(node == node.parent.left)
				return node.parent;
			node = node.parent;
		}
		
		return null;
	}

	public static void main(String[] args) {

	}

}
