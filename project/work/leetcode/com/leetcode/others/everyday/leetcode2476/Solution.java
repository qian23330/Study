package com.leetcode.others.everyday.leetcode2476;

/*
力扣-2476-二叉搜索树最近节点查询
每日一题-24.02.24-二叉搜索树-中序遍历
*/

import com.leetcode.util.TreeNode;
import com.leetcode.util.TreeSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        int n = res.size();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = res.get(i);  // 转数组提高效率
        }

        List<List<Integer>> ans = new ArrayList<>(queries.size());  // 预分配空间
        for (Integer query : queries) {
            int j = lowerBound(arr, query);
            int maxNum = j == n ? -1 : arr[j];
            if (j == n || arr[j] != query) {
                j--;
            }
            int minNum = j < 0 ? -1 : arr[j];
            ans.add(List.of(minNum, maxNum));
        }
        return ans;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    private int lowerBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一系列整数，以空格分隔，每行一组：");
        String[] input = scanner.nextLine().split(" ");
        TreeNode root = TreeSolution.constructBinaryTree(input);
        System.out.println("请输入一组数据，以空格分隔：");
        String[] arr = scanner.nextLine().split(" ");
        List<Integer> queries = Arrays.stream(arr)
                .map(Integer::parseInt)
                .toList();
        System.out.println(new Solution().closestNodes(root, queries));
    }
}
