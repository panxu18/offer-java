package com.xup.offer.ch4;

import java.util.Stack;

public class SerializeTree {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrderToSerialize(root,sb);
        return sb.toString();
    }

    private void preOrderToSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val);
        sb.append(',');
        preOrderToSerialize(root.left, sb);
        preOrderToSerialize(root.right, sb);
    }

    TreeNode deserializeWithLoop(String[] strs) {
        TreeNode p = null;
        Stack<TreeNode> stack = new Stack<>();
        int i = 0;
        stack.add(new TreeNode(Integer.valueOf(strs[i++])));
        TreeNode root = stack.peek();
        while (!stack.isEmpty() || (i < strs.length && !strs[i].equals("#"))) {
            while (i < strs.length && !strs[i].equals("#") ) {
                p = new TreeNode(Integer.valueOf(strs[i++]));
                stack.peek().left = p;
                stack.add(p);
            }
            if (!stack.empty()) {
                p = stack.pop();
                i++;
                if (i < strs.length && !strs[i].equals("#")) {
                    p.right = new TreeNode(Integer.valueOf(strs[i]));
                    stack.add(p.right);
                    i++;
                }
            }
        }
        return root;
    }

    TreeNode deserialize(String str) {
        if (str == null || str.length() <= 0 || str.charAt(0) == '#')
            return null;
        String[] strs = str.split(",");
//        return deserializeWithRecurency(strs);
        return deserializeWithLoop(strs);
    }

    int index = -1;
    TreeNode deserializeWithRecurency(String[] strs) {
        index++;
        if (strs[index].equals("#"))
            return null;
        TreeNode p = new TreeNode(Integer.valueOf(strs[index]));
        p.left = deserializeWithRecurency(strs);
        p.right = deserializeWithRecurency(strs);
        return p;
    }

    public static void main(String[] args) {
        SerializeTree st = new SerializeTree();
        TreeNode root = st.new TreeNode(8);
        TreeNode p = null;
        TreeNode q = null;
        p = root.left = st.new TreeNode(6);
        q = root.right = st.new TreeNode(10);
        p.left = st.new TreeNode(5);
        p.right = st.new TreeNode(7);
        q.left = st.new TreeNode(9);
        q.right = st.new TreeNode(11);

        System.out.println(st.serialize(root));
        TreeNode root2 = st.deserialize(st.serialize(root));
        System.out.println(st.serialize(root2));
    }
}
