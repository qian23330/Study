# 力扣-121-买卖股票的最佳时机
# 贪心


from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        cost, profit = float('+inf'), 0
        for price in prices:
            cost = min(cost, price)
            profit = max(profit, price - cost)
        return profit


if __name__ == '__main__':
    prices = [int(x) for x in input().split()]
    print(Solution().maxProfit(prices))
