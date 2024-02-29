package com.leetcode.hot100.贪心.leetcode0121;

/*
力扣-121-买卖股票的最佳时机
hot100-贪心
 */

import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println("请输入一组数字，以空格分隔：");
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] prices = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(new Solution().maxProfit(prices));
    }
}
