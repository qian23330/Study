package com.leetcode.hot100.贪心.leetcode0055;

/*
力扣-55-跳跃游戏
hot100-贪心
 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length, rightMax = 0;
        for (int i = 0; i < len; i++) {
            if (i <= rightMax) {
                rightMax = Math.max(rightMax, i + nums[i]);
                if (rightMax >= len - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(new Solution().canJump(nums));
    }
}
