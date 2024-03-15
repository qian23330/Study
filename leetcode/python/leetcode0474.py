### 力扣-474-一和零 ###
# 动态规划-01背包问题


from typing import List


class Solution:
    def findMaxForm(self, strs: List[str], m: int, n: int) -> int:
        dp = [[0] * (n + 1) for _ in range(m + 1)]  # 创建二维动态规划数组，初始化为0
        for s in strs:  # 遍历物品
            zeroNum = s.count('0')  # 统计0的个数
            oneNum = len(s) - zeroNum  # 统计1的个数
            for i in range(m, zeroNum - 1, -1):  # 遍历背包容量且从后向前遍历
                for j in range(n, oneNum - 1, -1):
                    dp[i][j] = max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1)  # 状态转移方程
        return dp[m][n]


if __name__ == '__main__':
    strs = list(map(str, input().split()))
    m = int(input())
    n = int(input())
    print(Solution().findMaxForm(strs, m, n))
