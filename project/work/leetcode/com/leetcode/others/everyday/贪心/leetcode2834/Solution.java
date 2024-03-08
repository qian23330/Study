package com.leetcode.others.everyday.贪心.leetcode2834;

/*
力扣-2834-找出美丽数组的最小和
每日一题-24.03.08-贪心-等差数列
*/

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int minimumPossibleSum(int n, int target) {
        final int MOD = (int) 1e9 + 7;
        int m = target / 2;
        if (n <= m) {
            return (int) ((long) (1 + n) * n / 2 % MOD);
        }
        return (int) (((long) (1 + m) * m / 2 + ((long) target + target + (n - m) - 1) * (n - m) / 2) % MOD);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] pairs = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = pairs[0];
        int target = pairs[1];
        System.out.println(new Solution().minimumPossibleSum(n, target));
    }
}

