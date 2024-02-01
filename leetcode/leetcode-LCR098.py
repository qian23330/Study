# 力扣-LCR098-不同路径
# 动态规划


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0] * n for _ in range(m)]
        for i in range(1, m):
            dp[i][0] = 1
        for j in range(1, n):
            dp[0][j] = 1
        dp[0][0] = 1


        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        return dp[-1][-1]


if __name__ == '__main__':
    m = int(input())
    n = int(input())
    print(Solution().uniquePaths(m, n))
