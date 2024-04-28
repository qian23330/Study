package com.leetcode.hot100.二叉树.leetcode0124;

/*
力扣-124-二叉树中的最大路径和
hot100-二叉树-递归
 */

import com.leetcode.utils.TreeNode;
import com.leetcode.utils.TreeSolution;

import java.util.Scanner;

class Solution {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);  // 计算节点的最大贡献值
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        int cur = node.val + left + right;
        maxSum = Math.max(maxSum, cur);
        return Math.max(Math.max(left, right) + node.val, 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        TreeNode root = TreeSolution.constructBinaryTree(input);
        System.out.println(new Solution().maxPathSum(root));
    }
}
