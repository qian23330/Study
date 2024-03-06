package com.leetcode.hot100.二叉树.leetcode0101;

/*
力扣-101-对称二叉树
hot100-二叉树-递归
 */

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeSolution;

import java.util.Scanner;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        TreeNode root = TreeSolution.constructBinaryTree(input);
        System.out.println(new Solution().isSymmetric(root));
    }
}
