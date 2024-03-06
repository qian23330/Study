package com.leetcode.others.normal.二叉树.leetcode0144;

/*
力扣-144-二叉树的前序遍历
normal-二叉树
 */

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeSolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    private void preorder(TreeNode node, List<Integer> res) {
        if (node == null) return;
        res.add(node.val);
        preorder(node.left, res);
        preorder(node.right, res);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        TreeNode root = TreeSolution.constructBinaryTree(input);
        System.out.println(new Solution().preorderTraversal(root));
    }
}
