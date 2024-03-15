package com.leetcode.hot100.动态规划.leetcode0152;

/*
力扣-152-乘积最大子数组
hot100-动态规划-滚动数组
 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int res = nums[0], maxF = res, minF = res;
        for (int i = 1; i < len; i++) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            res = Math.max(maxF, res);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(new Solution().maxProduct(nums));
    }
}
