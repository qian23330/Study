package com.leetcode.hot100.动态规划.leetcode1143;

/*
力扣-1143-最长公共子序列
hot100-动态规划
 */

import java.util.Scanner;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();
        int[][] dp = new int[n1 + 1][n2 + 2];
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串1：");
        String text1 = scanner.nextLine();
        System.out.println("请输入字符串2：");
        String text2 = scanner.nextLine();
        System.out.println(new Solution().longestCommonSubsequence(text1, text2));
    }
}
