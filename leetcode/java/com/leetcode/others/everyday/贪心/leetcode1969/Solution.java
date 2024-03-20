package com.leetcode.others.everyday.贪心.leetcode1969;

/*
力扣-1969-数组元素的最小非零乘积
每日一题-24.03.20-贪心-快速幂
*/

import java.util.Scanner;

class Solution {
    private static final int MOD = 1_000_000_007;

    private long pow(long x, int p) {
        x %= MOD;
        long res = 1;
        while (p-- > 0) {
            res = res * x % MOD;
            x = x * x % MOD;
        }
        return res;
    }

    public int minNonZeroProduct(int p) {
        long k = (1L << p) - 1;
        return (int) (k % MOD * pow(k - 1, p - 1) % MOD);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        System.out.println(new Solution().minNonZeroProduct(p));
    }
}
