### 力扣-122-买卖股票的最佳时机 2 ###
# 贪心


from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        result = 0
        for i in range(1, len(prices)):
            result += max(prices[i] - prices[i - 1], 0)
        return result


if __name__ == '__main__':
    prices = list(map(int, input().split()))
    print(Solution().maxProfit(prices))
