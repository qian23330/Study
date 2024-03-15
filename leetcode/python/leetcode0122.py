### 力扣-122-买卖股票的最佳时机 2 ###
# 贪心/动态规划


from typing import List


class Solution:
    # 贪心
    def maxProfit(self, prices: List[int]) -> int:
        result = 0
        for i in range(1, len(prices)):
            result += max(prices[i] - prices[i - 1], 0)
        return result

    # 动态规划
    def maxProfit(self, prices: List[int]) -> int:
        length = len(prices)
        dp = [[0] * 2 for _ in range(length)]
        dp[0][0] = -prices[0]
        dp[0][1] = 0
        for i in range(1, length):
            dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] - prices[i])  # 注意这里是和121. 买卖股票的最佳时机唯一不同的地方
            dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] + prices[i])
        return dp[-1][1]


if __name__ == '__main__':
    prices = list(map(int, input().split()))
    print(Solution().maxProfit(prices))
