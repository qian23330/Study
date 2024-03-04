package com.leetcode.hot100.动态规划.leetcode0322;

/*
力扣-322-零钱兑换
hot100-动态规划-完全背包
 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] coins = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        int amount = scanner.nextInt();
        System.out.println(new Solution().coinChange(coins, amount));
    }
}
