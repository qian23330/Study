package com.leetcode.hot100.leetcode0121;

/*
力扣-121-买卖股票的最佳时机
hot100-贪心
 */

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
        System.out.println("请输入一组数据，以逗号分隔：");
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        int[] prices = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            prices[i] = Integer.parseInt(input[i]);
        }
        System.out.println(new Solution().maxProfit(prices));
    }
}
