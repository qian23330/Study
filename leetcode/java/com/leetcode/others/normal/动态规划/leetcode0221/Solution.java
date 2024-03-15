package com.leetcode.others.normal.动态规划.leetcode0221;

/*
力扣-221-最大正方形
normal-动态规划
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxLen = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxLen;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];  // dp[i][j]表示以i，i为右下角，且只包含1的正方形的最大边长值
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen * maxLen;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<char[]> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isBlank()) break;
            char[] nums = line.replace(" ", "").toCharArray();
            list.add(nums);
        }
        char[][] matrix = list.toArray(new char[0][]);
        System.out.println(new Solution().maximalSquare(matrix));
    }
}
