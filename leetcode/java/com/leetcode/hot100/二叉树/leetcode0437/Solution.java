package com.leetcode.hot100.二叉树.leetcode0437;

/*
力扣-437-路径总和 III
hot100-二叉树-回溯
*/

import com.leetcode.utils.TreeNode;
import com.leetcode.utils.TreeSolution;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    Map<Long, Integer> prefixMap;
    int target;

    public int pathSum(TreeNode root, int targetSum) {
        prefixMap = new HashMap<>();
        target = targetSum;
        prefixMap.put(0L, 1);
        return backtracking(root, 0L);
    }

    private int backtracking(TreeNode node, Long curSum) {
        if (node == null) return 0;
        int res = 0;
        curSum += node.val;
        res += prefixMap.getOrDefault(curSum - target, 0);
        prefixMap.merge(curSum, 1, Integer::sum);
        int left = backtracking(node.left, curSum);
        int right = backtracking(node.right, curSum);
        res = res + left + right;
        prefixMap.merge(curSum, -1, Integer::sum);
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        TreeNode node = TreeSolution.constructBinaryTree(input);
        int n = scanner.nextInt();
        System.out.println(new Solution().pathSum(node, n));
    }
}
