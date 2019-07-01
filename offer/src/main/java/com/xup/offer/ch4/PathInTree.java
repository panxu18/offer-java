package com.xup.offer.ch4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;
import java.util.stream.Collectors;

public class PathInTree {


	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;

		}

	}


	/*
	 * 非递归解法
	 */
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {

		if (root == null)
			return new ArrayList<ArrayList<Integer>>(0);

		int sum = 0;
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;
		/*
		 * 遍历左节点
		 */
		while (p != null) {
			sum += p.val;
			stack.push(p);
			p = p.left;
		}
		while (!stack.isEmpty()) {
			/*
			 * 遍历右节点
			 */
			p = stack.peek();
			if (p.right != null) {
				p = p.right;
				while (p != null) {
					sum += p.val;
					stack.push(p);
					p = p.left;
				}
			}
			/*
			 * 叶子节点
			 */
			p = stack.peek();
			if (p.left == null && p.right == null) {
				if (sum == target) {
					ArrayList<Integer> list = new ArrayList<>(stack.size());
					for (TreeNode e : stack) {
						list.add(e.val);
					}
					result.add(list);
					// stream操作可能会导致超时
					/*result.add((ArrayList<Integer>) stack.stream()
							.map((node)->node.val)
							.collect(Collectors.toList()));*/
				}
			}
			/*
			 * 出栈
			 */
			p = stack.pop();
			sum -= p.val;
			while (!stack.isEmpty() && stack.peek().right == p) {
				p = stack.pop();
				sum -= p.val;
			}
		}
		// stream操作可能会导致超时
		/*return result.stream()
				.sorted(Comparator.comparing(ArrayList<Integer>::size).reversed())
				.collect(Collectors.toList());*/
		return result;
	}
	
	
	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	ArrayList<Integer> list = new ArrayList<>();
	/*
	 * 递归解法
	 */
	public ArrayList<ArrayList<Integer>> FindPath2(TreeNode root, int target) {
		if (root == null)
			return new ArrayList<ArrayList<Integer>>(0);
		list.add(root.val);
		target -= root.val;
		if (root.left == null && root.right == null && target == 0) {
			result.add(new ArrayList<>(list));
		}
		if (root.left != null)
			FindPath2(root.left, target);
		if (root.right != null)
			FindPath2(root.right, target);
		list.remove(list.size() - 1);
		return result;
	}

	public static void main(String[] args) {
		PathInTree pathInTree = new PathInTree();
		TreeNode root = pathInTree.new TreeNode(10);
		root.left = pathInTree.new TreeNode(5);
		root.right = pathInTree.new TreeNode(12);
		TreeNode p = root.left;
		p.left = pathInTree.new TreeNode(4);
		p.right = pathInTree.new TreeNode(7);
		System.out.println(pathInTree.FindPath(root, 22));

	}

}
