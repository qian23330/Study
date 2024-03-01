package com.leetcode.hot100.动态规划.leetcode0416;

/*
力扣-416-分割等和子集
hot100-动态规划-01背包
 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length, sum = 0;
        if (n == 0) return false;
        
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
        }
        return dp[target] == target;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(new Solution().canPartition(nums));
    }
}
