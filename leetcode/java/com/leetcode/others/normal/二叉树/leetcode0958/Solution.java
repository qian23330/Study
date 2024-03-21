package com.leetcode.others.normal.二叉树.leetcode0958;

/*
力扣-958-二叉树的完全性检验
normal-二叉树-dfs/bfs
 */


import com.leetcode.utils.TreeNode;
import com.leetcode.utils.TreeSolution;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    int size = 0;

    // dfs
    public boolean isCompleteTree(TreeNode root) {
        setNumber(root, 1);
        return test(root, size);
    }

    private void setNumber(TreeNode root, int number) {
        if (root == null) return;
        root.val = number;
        size++;
        setNumber(root.left, 2 * number);
        setNumber(root.right, 2 * number + 1);
    }

    private boolean test(TreeNode root, int size) {
        if (root == null) return true;
        if (root.val > size) return false;
        return test(root.left, size) && test(root.right, size);
    }


    // bfs
    public boolean isCompleteTree2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        boolean hasNullNode = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (hasNullNode && node != null) {
                return false;
            }
            if (node == null) {
                hasNullNode = true;
                continue;
            }
            queue.offer(root.left);
            queue.offer(root.right);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        TreeNode root = TreeSolution.constructBinaryTree(input);
        System.out.println(new Solution().isCompleteTree(root));
    }
}
