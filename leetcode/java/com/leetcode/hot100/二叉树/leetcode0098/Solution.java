package com.leetcode.hot100.二叉树.leetcode0098;

/*
力扣-98-验证二叉搜索树
hot100-二叉搜索树-中序
 */

import com.leetcode.utils.TreeNode;
import com.leetcode.utils.TreeSolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    List<Integer> list = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        inorder(root, list);
        return isSearchTree(list);
    }

    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    private boolean isSearchTree(List<Integer> list) {
        int n = list.size();
        for (int i = 1; i < n; i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        TreeNode root = TreeSolution.constructBinaryTree(input);
        System.out.println(new Solution().isValidBST(root));
    }
}
