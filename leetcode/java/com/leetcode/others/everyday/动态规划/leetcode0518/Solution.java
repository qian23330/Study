package com.leetcode.others.everyday.动态规划.leetcode0518;

/*
力扣-518-零钱兑换 II
每日一题-24.03.25-动态规划-完全背包
 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        String[] input = scanner.nextLine().split(" ");
        int[] coins = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(new Solution().change(amount, coins));
    }
}
