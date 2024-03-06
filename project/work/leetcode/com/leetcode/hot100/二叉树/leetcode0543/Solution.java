package com.leetcode.hot100.二叉树.leetcode0543;

/*
力扣-543-二叉树的直径
hot100-二叉树-后序
 */

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeSolution;

import java.util.Scanner;

class Solution {
    int res;

    public int diameterOfBinaryTree(TreeNode root) {
        res = 1;
        depth(root);
        return res - 1;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        int L = depth(node.left);  // 左儿子为根
        int R = depth(node.right);  // 右儿子为根
        res = Math.max(res, L + R + 1);
        return Math.max(L, R) + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        TreeNode root = TreeSolution.constructBinaryTree(input);
        System.out.println(new Solution().diameterOfBinaryTree(root));
    }
}
