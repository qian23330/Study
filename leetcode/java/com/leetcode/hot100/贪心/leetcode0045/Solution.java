package com.leetcode.hot100.贪心.leetcode0045;

/*
力扣-45-跳跃游戏 II
hot100-贪心
 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int maxPos = 0, end = 0, count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (i <= maxPos) {
                maxPos = Math.max(maxPos, i + nums[i]);
                if (i == end) {
                    end = maxPos;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(new Solution().jump(nums));
    }
}
