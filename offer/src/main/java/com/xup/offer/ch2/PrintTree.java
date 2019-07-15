package com.xup.offer.ch2;

import java.util.ArrayList;
import java.util.Collections;

public class PrintTree {
	
	
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;
	    }
	}
	

	/**
	 * 利用队列进行层次遍历，一次处理以层
	 * @author xupan
	 * @date 2019年7月15日
	 * @param pRoot
	 * @return
	 */
	public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		if (pRoot == null)
			return new ArrayList<>(0);
		ArrayList<ArrayList<Integer>> resultAll = new ArrayList<>();
		ArrayList<TreeNode> queue = new ArrayList<>();
		ArrayList<TreeNode> tempQueue = null;
		int level = 1;
		ArrayList<Integer> result  = null;
		// 根节点入队
		queue.add(pRoot);
		while (!queue.isEmpty()) {
			result = new ArrayList<>();
			tempQueue = new ArrayList<>();
			for(TreeNode node : queue) {
				result.add(node.val);
				if (node.left != null)
					tempQueue.add(node.left);
				if (node.right != null)
					tempQueue.add(node.right);
			}
			if (level % 2 == 0)
				Collections.reverse(result);
			resultAll.add(result);
			queue = tempQueue;
			level++;
		}
		return resultAll;
    }
	
}
