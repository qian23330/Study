package com.leetcode.others.normal.二叉树.leetcode0662;

/*
力扣-662-二叉树最大宽度
normal-二叉树-dfs
 */

import com.leetcode.utils.TreeNode;
import com.leetcode.utils.TreeSolution;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    int res = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public int widthOfBinaryTree(TreeNode root) {
        dfs(root, 1, 0);
        return res;
    }

    private void dfs(TreeNode node, int index, int level) {
        if (node == null) return;
        map.putIfAbsent(level, index);  // 每一层最先访问到的节点会是最左边的节点，即每一层编号的最小值
        res = Math.max(res, index - map.get(level) + 1);
        dfs(node.left, 2 * index, level + 1);
        dfs(node.right, 2 * index + 1, level + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        TreeNode root = TreeSolution.constructBinaryTree(input);
        System.out.println(new Solution().widthOfBinaryTree(root));
    }
}
