package com.leetcode.hot100.二叉树.leetcode0226;

import com.leetcode.utils.TreeNode;
import com.leetcode.utils.TreeSolution;
import java.util.Scanner;

/*
力扣-226-翻转二叉树
hot100-二叉树
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        invertTree(root.left);
        invertTree(root.right);
        swap(root);
        return root;
    }

    private void swap(TreeNode root) {
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        TreeNode root = TreeSolution.constructBinaryTree(input);
        TreeSolution.printTree(new Solution().invertTree(root));
    }
}
