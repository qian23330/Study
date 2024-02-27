package com.leetcode.others.normal.leetcode0103;

/*
力扣-103-二叉树的锯齿形层序遍历
normal-二叉树-层序遍历-奇偶分离
 */

import com.leetcode.commons.TreeNode;
import com.leetcode.commons.TreeSolution;

import java.util.*;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }
        boolean flag = true;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                level.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            if (flag) {
                res.add(level);
            } else {
                Collections.reverse(level);
                res.add(level);
            }
            flag = !flag;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = TreeSolution.constructBinaryTree();
        System.out.println(new Solution().zigzagLevelOrder(root));
    }
}
