package com.leetcode.others.everyday.leetcode2583;

/*
力扣-2583-二叉树中的第 K 大层和
每日一题-24.02.23-二叉树-层序遍历
*/

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeSolution;

import java.util.*;

class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> sums = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            long sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            sums.add(sum);
        }
        if (k > sums.size()) {
            return -1;
        }
        Collections.sort(sums);
        return sums.get(sums.size() - k);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一系列整数，以空格分隔，每行一组：");
        String[] input = scanner.nextLine().split(" ");
        TreeNode root = TreeSolution.constructBinaryTree(input);
        System.out.println("请输入K的值：");
        int k = scanner.nextInt();
        System.out.println(new Solution().kthLargestLevelSum(root, k));
    }
}
