package com.leetcode.hot100.leetcode0094;

/*
力扣-94-二叉树的中序遍历
hot100-二叉树
 */

import com.leetcode.commons.TreeNode;
import com.leetcode.commons.TreeSolution;

import java.util.*;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            }
            else {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一系列整数，以空格分隔，每行一组：");
        String[] input = scanner.nextLine().split(" ");
        TreeNode root = TreeSolution.constructBinaryTree(input);
        TreeSolution.printTree(root);
        System.out.println(new Solution().inorderTraversal(root));
    }
}
