package com.leetcode.others.normal.二叉树.leetcode0129;

/*
力扣-129-求根节点到叶节点数字之和
normal-二叉树-dfs
 */

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeSolution;

import java.util.Scanner;

class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int i) {
        if (node == null) return 0;
        int num = node.val + i * 10;
        if (node.left == null && node.right == null) {
            return num;
        }
        return dfs(node.left, num) + dfs(node.right, num);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        TreeNode root = TreeSolution.constructBinaryTree(input);
        System.out.println(new Solution().sumNumbers(root));
    }
}
