### 力扣-1049-最后一块石头的重量2 ###
# 动态规划-01背包问题


class Solution:
    def lastStoneWeightII(self, stones):
        total_sum = sum(stones)
        target = total_sum // 2
        dp = [0] * (target + 1)
        for stone in stones:
            for j in range(target, stone - 1, -1):
                dp[j] = max(dp[j], dp[j - stone] + stone)
        return total_sum - 2 * dp[-1]


if __name__ == '__main__':
    stones = list(map(int, input().split()))
    print(Solution().lastStoneWeightII(stones))
