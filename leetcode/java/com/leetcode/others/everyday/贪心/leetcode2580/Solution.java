package com.leetcode.others.everyday.贪心.leetcode2580;

/*
力扣-2580-统计将重叠区间合并成组的方案数
每日一题-24.03.27-贪心
*/

import java.util.Arrays;

class Solution {
    public int countWays(int[][] ranges) {
        Arrays.sort(ranges, (a, b) -> a[0] - b[0]);
        int res = 1;
        int maxR = -1;
        for (int[] p : ranges) {
            if (p[0] > maxR) { // 无法合并
                res = res * 2 % 1_000_000_007; // 新区间
            }
            maxR = Math.max(maxR, p[1]); // 合并
        }
        return res;
    }
}
