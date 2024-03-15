package com.leetcode.others.everyday.二叉树.leetcode1261;

/*
力扣-1261-在受污染的二叉树中查找元素
每日一题-24.03.12-二叉树-哈希
*/

import com.leetcode.utils.TreeNode;

import java.util.HashSet;
import java.util.Set;

class FindElements {
    Set<Integer> set = new HashSet<>();

    public FindElements(TreeNode root) {
        dfs(root, 0);
    }

    private void dfs(TreeNode node, int val) {
        if (node == null) return;
        set.add(val);
        dfs(node.left, val * 2 + 1);
        dfs(node.right, val * 2 + 2);
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}
