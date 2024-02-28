package com.leetcode.others.everyday.leetcode0235;

/*
力扣-235-二叉搜索树的最近公共祖先
每日一题-24.02.25-二叉搜索树
*/

import com.leetcode.commons.TreeNode;
import com.leetcode.commons.TreeSolution;

import java.util.Scanner;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一系列整数，以空格分隔，每行一组：");
        String[] input1 = scanner.nextLine().split(" ");
        TreeNode root = TreeSolution.constructBinaryTree(input1);
        String[] input2 = scanner.nextLine().split(" ");
        TreeNode p = TreeSolution.constructBinaryTree(input2);
        String[] input3 = scanner.nextLine().split(" ");
        TreeNode q = TreeSolution.constructBinaryTree(input3);
        TreeNode res = new Solution().lowestCommonAncestor(root, p, q);
        System.out.println(res.val);
    }
}
