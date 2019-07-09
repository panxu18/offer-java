package com.xup.offer.ch6;

public class TreeDepth {
	
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	
	/**
	 * 利用递归判断左子树的深度和右子树的深度，然后计算当前的深度
	 * 如果根节点为空则深度为0
	 * @param root
	 * @return
	 */
	public int treeDepth(TreeNode root) {
         if (root == null) 
        	 return 0;
         int leftDepth = treeDepth(root.left);
         int rightDepth = treeDepth(root.right);
         return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }
}
