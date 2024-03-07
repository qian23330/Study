package com.leetcode.others.practice;

/*
力扣
practice-练习
 */

import com.leetcode.util.TreeNode;

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == targetSum) return true;
        return hasPathSum(root.left, targetSum - root.val) && hasPathSum(root.right, targetSum - root.val);
    }
}

