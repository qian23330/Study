package com.leetcode.others.everyday.双指针.leetcode1793;

/*
力扣-1793-好子数组的最大分数
每日一题-24.03.19-双指针
*/

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int i = k, j = i;
        int res = nums[k], height = res;
        for (int l = 0; l < n - 1; l++) {
            if (j == n - 1 || i > 0 && nums[i - 1] > nums[j + 1]) {
                height = Math.min(height, nums[--i]);
            } else {
                height = Math.min(height, nums[++j]);
            }
            res = Math.max(res, height * (j - i + 1));
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        String[] input = scanner.nextLine().split(" ");
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(new Solution().maximumScore(nums, k));
    }
}
