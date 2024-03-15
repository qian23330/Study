package com.leetcode.hot100.二叉树.leetcode0105;

/*
力扣-105-从前序与中序遍历序列构造二叉树
hot100-二叉树-构造
 */

import com.leetcode.utils.TreeNode;
import com.leetcode.utils.TreeSolution;

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0) return null;
        if (n == 1) return new TreeNode(preorder[0]);

        int leftSize = indexOf(inorder, preorder[0]);
        int[] pre1 = Arrays.copyOfRange(preorder, 1, 1 + leftSize);
        int[] pre2 = Arrays.copyOfRange(preorder, 1 + leftSize, n);
        int[] in1 = Arrays.copyOfRange(inorder, 0, leftSize);
        int[] in2 = Arrays.copyOfRange(inorder, 1 + leftSize, n);
        TreeNode left = buildTree(pre1, in1);
        TreeNode right = buildTree(pre2, in2);
        return new TreeNode(preorder[0], left, right);
    }

    private int indexOf(int[] nums, int x) {
        for (int i = 0; ; i++) {
            if (nums[i] == x) {
                return i;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input1 = scanner.nextLine().split(" ");
        String[] input2 = scanner.nextLine().split(" ");
        int[] preorder = Arrays.stream(input1)
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] inorder = Arrays.stream(input2)
                .mapToInt(Integer::parseInt)
                .toArray();
        TreeNode root = new Solution().buildTree(preorder, inorder);
        TreeSolution.printTree(root);
    }
}
