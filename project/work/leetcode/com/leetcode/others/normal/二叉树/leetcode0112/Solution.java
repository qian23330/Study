package com.leetcode.others.normal.二叉树.leetcode0112;

/*
力扣-112-路径总和
normal-二叉树-dfs
 */

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeSolution;

import java.util.Scanner;

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        TreeNode root = TreeSolution.constructBinaryTree(input);
        int targetSum = scanner.nextInt();
        System.out.println(new Solution().hasPathSum(root, targetSum));
    }
}
