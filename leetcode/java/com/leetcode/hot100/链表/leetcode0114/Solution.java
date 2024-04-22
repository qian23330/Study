package com.leetcode.hot100.链表.leetcode0114;

/*
力扣-114-二叉树展开为链表
hot100-链表
 */

import com.leetcode.utils.TreeNode;
import com.leetcode.utils.TreeSolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    List<TreeNode> list = new ArrayList<>();
    public void flatten(TreeNode root) {
        preorder(root);
        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i - 1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }

    private void preorder(TreeNode node) {
        if (node == null) return;
        list.add(node);
        preorder(node.left);
        preorder(node.right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        TreeNode node = TreeSolution.constructBinaryTree(input);
        new Solution().flatten(node);
        TreeSolution.printTree(node);
    }
}
