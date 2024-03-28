package com.leetcode.others.everyday.动态规划.leetcode1997;

/*
力扣-1997-访问完所有房间的第一天
每日一题-24.03.28-动态规划-前缀和
 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        final long MOD = 1_000_000_007;
        int n = nextVisit.length;
        long[] s = new long[n];
        for (int i = 0; i < n - 1; i++) {
            int j = nextVisit[i];
            s[i + 1] = (s[i] * 2 - s[j] + 2 + MOD) % MOD; // + MOD 避免算出负数
        }
        return (int) s[n - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nextVisit = Arrays.stream(input)
                        .mapToInt(Integer::parseInt)
                        .toArray();
        System.out.println(new Solution().firstDayBeenInAllRooms(nextVisit));
    }
}
