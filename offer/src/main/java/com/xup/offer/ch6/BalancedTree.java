package com.xup.offer.ch6;

public class BalancedTree {
	
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}
	
	/**
	 * 通过计算左右子树的深度判断是否是平衡二叉树
	 * @param root
	 * @return
	 */
	public boolean isBalanced(TreeNode root) {
		return treeDepth(root) >= 0;
	}
	
	public int treeDepth(TreeNode root) {
        if (root == null) 
       	 return 0;
        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        if (leftDepth == -1 ||
        		rightDepth == -1 ||
        		Math.abs(leftDepth - rightDepth) > 1)
        	return -1;
        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
   }
}
