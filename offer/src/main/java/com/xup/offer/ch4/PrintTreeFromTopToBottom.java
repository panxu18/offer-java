package com.xup.offer.ch4;

import java.util.ArrayList;

public class PrintTreeFromTopToBottom {

	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}

	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		if (root == null)
			return new ArrayList<>(0);
		
		ArrayList<TreeNode> queue = new ArrayList<>();
		ArrayList<Integer> result = new ArrayList<>();
		queue.add(root);
		TreeNode p = null;
		while (!queue.isEmpty()) {
			p = queue.get(0);
			queue.remove(0);
			result.add(p.val);
			if (p.left != null)
				queue.add(p.left);
			if (p.right != null)
				queue.add(p.right);
		}
		return result;
	}

}
