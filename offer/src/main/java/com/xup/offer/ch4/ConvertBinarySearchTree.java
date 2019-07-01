package com.xup.offer.ch4;

public class ConvertBinarySearchTree {
	
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	

	public TreeNode Convert(TreeNode pRootOfTree) {
		if (pRootOfTree == null)
			return null;
		TreeNode leftHead = Convert(pRootOfTree.left);
		TreeNode rightHead = Convert(pRootOfTree.right);
		if (leftHead != null) {
			TreeNode pNode = leftHead;
			while (pNode.right != null) 
				pNode = pNode.right;
			pNode.right = pRootOfTree;
			pRootOfTree.left = pNode;
		}
		if (rightHead != null) {
			pRootOfTree.right = rightHead;
			rightHead.left = pRootOfTree;
		}
		return leftHead == null ? pRootOfTree : leftHead;
	}
	
	
	
}
