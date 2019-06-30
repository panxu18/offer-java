package com.xup.offer.ch4;

public class MirrorOfBinarryTree {

	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}


	public void Mirror(TreeNode root) {
		if (root == null)
			return;
		Mirror(root.left);
		Mirror(root.right);
		TreeNode p = root.left;
		root.left = root.right;
		root.right = p;
	}
}
