### 力扣-518-零钱兑换2 ###
# 动态规划-完全背包问题


from typing import List


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [0]*(amount + 1)
        dp[0] = 1
        # 遍历物品
        for i in range(len(coins)):
            # 遍历背包
            for j in range(coins[i], amount + 1):
                dp[j] += dp[j - coins[i]]
        return dp[amount]


if __name__ == '__main__':
    amount = int(input())
    coins = [int(x) for x in input().split()]
    print(Solution().change(amount, coins))
