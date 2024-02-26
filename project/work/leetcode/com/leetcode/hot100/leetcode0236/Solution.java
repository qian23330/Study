package com.leetcode.hot100.leetcode0236;

/*
力扣-236-二叉树的最近公共祖先
hot100-前序遍历/dfs
 */

import com.leetcode.commons.TreeNode;
import com.leetcode.commons.TreeSolution;

import java.util.Scanner;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null) {
            return null;
        }
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeSolution.constructBinaryTree();
        System.out.println("请输入p、q的值，以逗号分隔：");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int a = Integer.parseInt(input.split(",")[0]);
        int b = Integer.parseInt(input.split(",")[1]);
        TreeNode p = TreeSolution.findNode(root, a);
        TreeNode q = TreeSolution.findNode(root, b);
        TreeNode res = new Solution().lowestCommonAncestor(root, p, q);
        System.out.println(res.val);
    }
}
