package com.leetcode.others.everyday.leetcode0889;

/*
力扣-889-根据前序和后序遍历构造二叉树
每日一题-24.02.22-二叉树-构造
*/

import com.leetcode.commons.TreeNode;
import com.leetcode.commons.TreeSolution;

import java.util.Arrays;
import java.util.Scanner;


class Solution {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        if (n == 0) {  // 空节点
            return null;
        }
        if (n == 1) {  // 叶子节点
            return new TreeNode(preorder[0]);
        }
        int leftSize = indexOf(postorder, preorder[1]) + 1;  // 左子树的大小
        int[] pre1 = Arrays.copyOfRange(preorder, 1, 1 + leftSize);
        int[] pre2 = Arrays.copyOfRange(preorder, 1 + leftSize, n);
        int[] post1 = Arrays.copyOfRange(postorder, 0, leftSize);
        int[] post2 = Arrays.copyOfRange(postorder, leftSize, n - 1);
        TreeNode left = constructFromPrePost(pre1, post1);
        TreeNode right = constructFromPrePost(pre2, post2);
        return new TreeNode(preorder[0], left, right);
    }

    // 返回 x 在 a 中的下标，保证 x 一定在 a 中
    private int indexOf(int[] a, int x) {
        for (int i = 0; ; i++) {
            if (a[i] == x) {
                return i;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("前序数组，请输入几个数并用逗号隔开：");
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String[] arr1  = str1.split(",");
        int[] pre = Arrays.stream(arr1)
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println("后序数组，请输入几个数并用逗号隔开：");
        String str2 = scanner.nextLine();
        String[] arr2  = str2.split(",");
        int[] post = Arrays.stream(arr2)
                .mapToInt(Integer::parseInt)
                .toArray();
        TreeSolution.printTree(new Solution().constructFromPrePost(pre, post));
    }
}

