package com.leetcode.others.everyday.动态规划.leetcode2684;

/*
力扣-2684-矩阵中移动的最大次数
每日一题-24.03.16-动态规划/dfs
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {
    public int maxMoves(int[][] grid) {  // dp
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int res = 0;
        for (int j = n - 2; j >= 0; j--) {
            for (int i = 0; i < m; i++) {
                for (int k = Math.max(i - 1, 0); k < Math.min(i + 2, m); k++) {
                    if (grid[k][j + 1] > grid[i][j]) {
                        dp[i][j] = Math.max(dp[i][j], dp[k][j + 1] + 1);
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            res = Math.max(res, dp[i][0]);
        }
        return res;
    }


    private int ans;

    public int maxMoves2(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            dfs(grid, i, 0);
        }
        return ans;
    }

    private void dfs(int[][] grid, int i, int j) {
        ans = Math.max(ans, j);
        if (ans == grid[0].length - 1) return;
        for (int k = Math.max(i - 1, 0); k < Math.min(i + 2, grid.length); k++) {
            if (grid[k][j + 1] > grid[i][j]) {
                dfs(grid, k, j + 1);
            }
        }
        grid[i][j] = 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<int[]> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isBlank()) break;
            int[] nums = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            list.add(nums);
        }
        int[][] grid = list.toArray(new int[0][]);
        System.out.println(new Solution().maxMoves(grid));
    }
}
