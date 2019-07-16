package com.xup.offer.ch2;

public class NextNodeInBinaryTrees {
	
	public class TreeLinkNode {
	    int val;
	    TreeLinkNode left = null;
	    TreeLinkNode right = null;
	    TreeLinkNode next = null;

	    TreeLinkNode(int val) {
	        this.val = val;
	    }
	}
	
	
	/**
	 * 中序遍历 左子树->根节点->右子树
	 * 给定某一节点t找下一个节点，有几种情况
	 * 1、如果该节点有右节点s
	 * 	a、右节点有左子树，找到左子树中第一个节点
	 *  b、右节点没有左子树，那么返回节点s
	 * 2、给节点没有右节点，向上找到一个还没有遍历的祖先节点
	 * @param node
	 * @return
	 */
	public TreeLinkNode findNextNode(TreeLinkNode pNode) {
		if (pNode == null)
			return null;
		TreeLinkNode p = null;
		if (pNode.right != null) {
			p = pNode.right;
			while (p.left != null)
				p = p.left;
			return p;
		}
		p = pNode;
		while (p.next != null && p.next.right == p)
			p = p.next;
		return p.next;
	}

	public static void main(String[] args) {

	}

}
