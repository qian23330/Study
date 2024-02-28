package com.leetcode.hot100.leetcode0300;

/*
力扣-300-最长递增子序列
hot100-动态规划
 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int res = 1;
        int n = nums.length;
        if (n <= 1) return n;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一组数，以空格间隔：");
        String[] input = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(new Solution().lengthOfLIS(nums));
    }
}
