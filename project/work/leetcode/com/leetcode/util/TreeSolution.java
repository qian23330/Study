package com.leetcode.util;

import java.util.*;

public class TreeSolution {
    public static TreeNode constructBinaryTree(String[] args) {

        TreeNode root;
        TreeNode[] tree = new TreeNode[args.length];

        for (int i = 0; i < args.length; i++) {
            if (!args[i].equalsIgnoreCase("null")) {
                tree[i] = new TreeNode(Integer.parseInt(args[i]));
            } else {
                tree[i] = null;
            }
        }

        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null && 2 * i + 1 < tree.length) {
                tree[i].left = tree[2 * i + 1];
                if (2 * i + 2 < tree.length) {
                    tree[i].right = tree[2 * i + 2];
                }
            }
        }
        root = tree[0];
        return root;
    }

    public static TreeNode findNode(TreeNode root, int val) {
        if(root == null || root.val == val) {
            return root;
        }

        TreeNode left = findNode(root.left, val);
        TreeNode right = findNode(root.right, val);

        if(left != null) {
            return left;
        } else {
            return right;
        }
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<String>> result = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<String> level = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                if (cur != null) {
                    level.add(Integer.toString(cur.val));
                    queue.add(cur.left);
                    queue.add(cur.right);
                } else {
                    level.add("null");
                }
            }
            if (level.stream().anyMatch(val -> !val.equals("null"))) {
                result.add(level);
            }
        }

        List<String> res = result.stream().flatMap(List::stream).toList();
        System.out.println(res);
    }
}
