package com.leetcode.hot100.二叉树.leetcode0110;

/*
力扣-110-平衡二叉树
hot100-二叉树-后序
 */

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeSolution;

import java.util.Scanner;

class Solution {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        TreeNode root = TreeSolution.constructBinaryTree(input);
        System.out.println(new Solution().isBalanced(root));
    }
}
