package com.leetcode.others.normal.二叉树.leetcode0113;

/*
力扣-113-路径总和 II
normal-二叉树-回溯
 */

import com.leetcode.utils.TreeNode;
import com.leetcode.utils.TreeSolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        backtracking(root, targetSum, res, path);
        return res;
    }

    private void backtracking(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> path) {
        if (root == null) return;
        path.add(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new ArrayList<>(path));
        }
        backtracking(root.left, targetSum, res, path);
        backtracking(root.right, targetSum, res, path);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        TreeNode root = TreeSolution.constructBinaryTree(input);
        int targetSum = scanner.nextInt();
        System.out.println(new Solution().pathSum(root, targetSum));
    }
}
