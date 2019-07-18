package com.xup.offer.ch4;

public class SymmetricalBinaryTree {

	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	
	boolean isSymmetrical(TreeNode pRoot) {
		if (pRoot == null)
			return true;
		return isSymmeticalWithRecurency(pRoot.left, pRoot.right);
	}
	
	boolean isSymmeticalWithRecurency(TreeNode left, TreeNode right) {
		if (left == null || right == null) {
			if (left == null && right == null)
				return true;
			else
				return false;
		}
		if (left.val != right.val)
			return false;
		return isSymmeticalWithRecurency(left.left, right.right)
				&& isSymmeticalWithRecurency(left.right, right.left);
	}
	
}
