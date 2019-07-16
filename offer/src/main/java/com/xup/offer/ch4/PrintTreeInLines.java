package com.xup.offer.ch4;

import java.util.ArrayList;

public class PrintTreeInLines {
	
	
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	
	
	ArrayList<ArrayList<Integer> > print(TreeNode pRoot) {
	    if (pRoot == null)
	    	return new ArrayList<>(0);
	    ArrayList<ArrayList<Integer>> resultAll = new ArrayList<>();
	    ArrayList<Integer> result = null;
	    ArrayList<TreeNode> queue = new ArrayList<>();
	    ArrayList<TreeNode> tempQueue = null;
	    // 根节点入队
	    queue.add(pRoot);
	    while (!queue.isEmpty()) {
	    	result = new ArrayList<>();
	    	tempQueue = new ArrayList<>();
	    	for (TreeNode node : queue) {
	    		result.add(node.val);
	    		if (node.left != null)
	    			tempQueue.add(node.left);
	    		if (node.right != null)
	    			tempQueue.add(node.right);
	    	}
	    	queue = tempQueue;
	    	resultAll.add(result);
	    	result = null;
	    	tempQueue = null;
	    }
	    return resultAll;
    }

}
