### 力扣-309-最佳买卖股票时机含冷冻期 ###
# 动态规划


from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        if n == 0:
            return 0
        dp = [[0] * 4 for _ in range(n)]  # 创建动态规划数组，4个状态分别表示持有股票、不持有股票且处于冷冻期、不持有股票且不处于冷冻期、不持有股票且当天卖出后处于冷冻期
        dp[0][0] = -prices[0]  # 初始状态：第一天持有股票的最大利润为买入股票的价格
        for i in range(1, n):
            dp[i][0] = max(dp[i-1][0], max(dp[i-1][3], dp[i-1][1]) - prices[i])  # 当前持有股票的最大利润等于前一天持有股票的最大利润或者前一天不持有股票且不处于冷冻期的最大利润减去当前股票的价格
            dp[i][1] = max(dp[i-1][1], dp[i-1][3])  # 当前不持有股票且处于冷冻期的最大利润等于前一天持有股票的最大利润加上当前股票的价格
            dp[i][2] = dp[i-1][0] + prices[i]  # 当前不持有股票且不处于冷冻期的最大利润等于前一天不持有股票的最大利润或者前一天处于冷冻期的最大利润
            dp[i][3] = dp[i-1][2]  # 当前不持有股票且当天卖出后处于冷冻期的最大利润等于前一天不持有股票且不处于冷冻期的最大利润
        return max(dp[n-1][3], dp[n-1][1], dp[n-1][2])  # 返回最后一天不持有股票的最大利润


if __name__ == '__main__':
    prices = [int(i) for i in input().strip().split()]
    print(Solution().maxProfit(prices))
