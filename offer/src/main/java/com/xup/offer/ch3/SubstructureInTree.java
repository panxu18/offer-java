package com.xup.offer.ch3;

public class SubstructureInTree {


	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	public boolean HasSubtree(TreeNode root1,TreeNode root2) {
		if (root1 == null || root2 == null)
			return false;
		if (isPrefix(root1, root2) || HasSubtree(root1.left, root2))
			return true;
		return HasSubtree(root1.right, root2);
		
	}
	
	private boolean isPrefix(TreeNode root1, TreeNode root2) {
		if (root2 == null)
			return true;
		if (root1 == null || root1.val != root2.val)
			return false;
		if (!isPrefix(root1.left, root2.left))
			return false;
		return isPrefix(root1.right, root2.right);
	}

	public static void main(String[] args) {
	}

}
