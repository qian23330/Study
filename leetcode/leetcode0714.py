### 力扣-714-买卖股票的最佳时机含手续费 ###
# 动态规划


from typing import List


class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        n = len(prices)
        dp = [[0] * 2 for _ in range(n)]
        dp[0][0] = -prices[0]  # 持股票
        for i in range(1, n):
            dp[i][0] = max(dp[i-1][0], dp[i-1][1] - prices[i])
            dp[i][1] = max(dp[i-1][1], dp[i-1][0] + prices[i] - fee)
        return max(dp[-1][0], dp[-1][1])


if __name__ == '__main__':
    fee = int(input())
    prices = [int(i) for i in input().strip().split()]
    print(Solution().maxProfit(prices, fee))
