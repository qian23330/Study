package com.leetcode.hot100.二叉树.leetcode0104;

/*
力扣-104-二叉树的最大深度
hot100-二叉树-后序/层序
 */

import com.leetcode.utils.TreeNode;
import com.leetcode.utils.TreeSolution;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class Solution {
//    public int maxDepth(TreeNode root) {
//        if (root == null) return 0;
//        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
//    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> deque = new LinkedList<>(), tmp;
        deque.offer(root);
        int depth = 0;
        while (!deque.isEmpty()) {
            tmp = new LinkedList<>();
            for (TreeNode node : deque) {
                if (node.left != null) {
                    tmp.offer(node.left);
                }
                if (node.right != null) {
                    tmp.offer(node.right);
                }
            }
            deque = tmp;
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        TreeNode root = TreeSolution.constructBinaryTree(input);
        System.out.println(new Solution().maxDepth(root));
    }
}
