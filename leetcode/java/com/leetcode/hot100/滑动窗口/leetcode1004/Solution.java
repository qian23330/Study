package com.leetcode.hot100.滑动窗口.leetcode1004;

/*
力扣-1004-最大连续1的个数 III
滑动窗口
 */

class Solution {
    public int longestOnes(int[] nums, int k) {
        int res = 0, cnt0 = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            cnt0 += 1 - nums[right];
            while (cnt0 > k) {
                cnt0 -= 1 - nums[left++];
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
