package com.xup.offer.ch2;

import java.util.Arrays;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode parent;
	
	TreeNode(int x) {
		val = x;
	}
}

public class ConstructBinaryTree {

	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		/*
		 * 前序和中序不匹配
		 */
		if (pre.length != in.length)
			throw new IllegalArgumentException();
		
		if (pre.length <= 0 || in.length <= 0)
			return null;
		
		int rootIndex = -1;
		for (int i = 0; i < in.length; i++) {
			if (in[i] == pre[0]) {
				rootIndex = i;
				break;
			}
		}
		/*
		 * 前序和中序不匹配
		 */
		if (rootIndex == -1)
			throw new IllegalArgumentException();
		TreeNode root = new TreeNode(pre[0]);
		/*
		 * 构建左子树
		 */
		root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, rootIndex +1),
				Arrays.copyOfRange(in, 0, rootIndex));
		/*
		 * 构建右子树
		 */
		root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, rootIndex + 1, pre.length),
				Arrays.copyOfRange(in, rootIndex + 1, in.length));
		
		return root;
	}
	
	public static void main(String[] args) {
		int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
		int[] in = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
		new ConstructBinaryTree().reConstructBinaryTree(pre, in);
	}

}
