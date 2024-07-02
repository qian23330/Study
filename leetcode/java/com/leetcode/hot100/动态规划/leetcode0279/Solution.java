package com.leetcode.hot100.动态规划.leetcode0279;

/*
力扣-279-完全平方数
hot100-动态规划
 */

import java.util.Scanner;

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minNum = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minNum = Math.min(minNum, dp[i - j * j]);
            }
            dp[i] = minNum + 1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(new Solution().numSquares(n));
    }
}
