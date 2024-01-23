# 力扣-62-不同路径
# 动态规划


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # 创建一个二维列表用于存储唯一路径数
        dp = [[0] * n for _ in range(m)]

        # 设置第一行和第一列的基本情况
        for i in range(m):
            dp[i][0] = 1
        for j in range(n):
            dp[0][j] = 1

        # 计算每个单元格的唯一路径数
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]

        # 返回右下角单元格的唯一路径数
        return dp[m - 1][n - 1]


if __name__ == '__main__':
    m, n = int(input()), int(input())
    print(Solution().uniquePaths(m, n))
