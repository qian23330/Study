package com.leetcode.commons;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TreeSolution {
    public static TreeNode constructBinaryTree() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数据，以逗号分隔：");
        String line = scanner.nextLine();
        if (line.isEmpty()) {
            return null;
        }
        String[] nums = line.split(",");
        TreeNode root = null;
        TreeNode[] tree = new TreeNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (!nums[i].equalsIgnoreCase("null")) {
                tree[i] = new TreeNode(Integer.parseInt(nums[i]));
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

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<String>> result = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<String> level = new ArrayList<>();
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
        System.out.println(result);
    }
}
