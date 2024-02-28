package com.leetcode.others.everyday.leetcode2673;

/*
力扣-2673-使二叉树所有路径值相等的最小代价
每日一题-24.02.28-二叉树-贪心
*/

import java.util.Scanner;

class Solution {
    public int minIncrements(int n, int[] cost) {
        int ans = 0;
        for (int i = n - 2; i > 0; i -= 2) {
            ans += Math.abs(cost[i] - cost[i + 1]);
            // 叶节点 i 和 i+1 的双亲节点下标为 i/2（整数除法）
            cost[i / 2] += Math.max(cost[i], cost[i + 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("请输入n：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        System.out.println("请输入一组数字，以逗号分隔：");
        String[] input = scanner.nextLine().split(",");
        int[] cost = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            cost[i] = Integer.parseInt(input[i]);
        }
        System.out.println(new Solution().minIncrements(n, cost));
    }
}
