package com.leetcode.others.everyday.leetcode0235;

/*
力扣-235-二叉搜索树的最近公共祖先
每日一题-24.02.25-二叉搜索树
*/

import com.leetcode.commons.TreeNode;
import com.leetcode.commons.TreeSolution;

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
        TreeNode root = TreeSolution.constructBinaryTree();
        TreeNode p = TreeSolution.constructBinaryTree();
        TreeNode q = TreeSolution.constructBinaryTree();
        TreeNode res = new Solution().lowestCommonAncestor(root, p, q);
        System.out.println(res.val);
    }
}
