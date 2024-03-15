package com.leetcode.others.normal.双指针.leetcode0209;

/*
力扣-209-长度最小的子数组
normal-滑动窗口
 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int minLen = Integer.MAX_VALUE;
        int left = 0, right = left;
        int curSum = 0;
        while (right < len) {
            curSum += nums[right];
            while (curSum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                curSum -= nums[left];
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int target = scanner.nextInt();
        int[] nums = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(new Solution().minSubArrayLen(target, nums));
    }
}
