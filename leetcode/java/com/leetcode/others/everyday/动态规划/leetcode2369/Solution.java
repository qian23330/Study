package com.leetcode.others.everyday.动态规划.leetcode2369;

/*
力扣-2369-检查数组是否存在有效划分
每日一题-24.03.01-动态规划
*/

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int i = 2; i <= nums.length; i++){
            int cur = nums[i - 1];
            if(dp[i - 2] && nums[i - 2] == cur){
                dp[i] = true;
            }
            if(i > 2 && dp[i - 3] && nums[i - 3] == nums[i - 2] && nums[i - 2] == cur){
                dp[i] = true;
            }
            if(i > 2 && dp[i - 3] && nums[i - 3] + 2 == nums[i - 2] + 1 && nums[i - 2] + 1 == cur){
                dp[i] = true;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(new Solution().validPartition(nums));
    }
}
