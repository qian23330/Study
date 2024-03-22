package com.leetcode.LCR.leetcodeLCR174;

/*
力扣-174-寻找二叉搜索树中的目标节点
LCR-二叉搜索树-dfs
 */

import com.leetcode.utils.TreeNode;
import com.leetcode.utils.TreeSolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    List<Integer> list = new ArrayList<>();

    public int findTargetNode(TreeNode root, int cnt) {
        inorder(root);
        return list.get(list.size() - cnt);
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        TreeNode root = TreeSolution.constructBinaryTree(input);
        int cnt = scanner.nextInt();
        System.out.println(new Solution().findTargetNode(root, cnt));
    }
}
