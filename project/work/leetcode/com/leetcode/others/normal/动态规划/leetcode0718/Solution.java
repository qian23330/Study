package com.leetcode.others.normal.动态规划.leetcode0718;

/*
力扣-718-最长重复子数组
normal-动态规划
 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        int res = 0;
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2 ; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input1 = scanner.nextLine().split(" ");
        String[] input2 = scanner.nextLine().split(" ");
        int[] nums1 = Arrays.stream(input1)
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] nums2 = Arrays.stream(input1)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(new Solution().findLength(nums1, nums2));
    }
}
