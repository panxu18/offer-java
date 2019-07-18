package com.xup.offer.ch4;

public class KthNodeInTree {
	
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	
	int n = 0;
	/**
	 * 通过中序遍历查找第k个元素
	 * @param pRoot
	 * @param k
	 * @return
	 */
	TreeNode kthNode(TreeNode pRoot, int k) {
		if (pRoot == null)
			return null;
		n = k;
		return inOrder(pRoot);
        
    }
	/**
	 * 递归中序遍历
	 * @param root
	 * @param k
	 * @return 返回第k个元素
	 */
	private TreeNode inOrder(TreeNode root) {
		if (root == null)
			return null;
		TreeNode result = inOrder(root.left);
		if (result != null)
			return result;
		if (--n == 0)
			return root;
		return inOrder(root.right);
	}
}
