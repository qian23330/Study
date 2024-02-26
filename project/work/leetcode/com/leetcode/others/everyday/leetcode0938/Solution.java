package com.leetcode.others.everyday.leetcode0938;

/*
力扣-938-二叉搜索树的范围和
每日一题-24.02.26-二叉搜索树-中序遍历
*/

import com.leetcode.commons.TreeNode;
import com.leetcode.commons.TreeSolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        List<Integer> res = new ArrayList<>();
        int sum = 0;
        inorder(root, res);
        for (int i = res.indexOf(low); i <= res.indexOf(high); i++) {
            sum += res.get(i);
        }
        return sum;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    public static void main(String[] args) {
        TreeNode root = TreeSolution.constructBinaryTree();
        System.out.println("请输入low和high，以逗号分隔：");
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        int low = Integer.parseInt(input[0]);
        int high = Integer.parseInt(input[1]);
        System.out.println(new Solution().rangeSumBST(root, low, high));
    }
}
