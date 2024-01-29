# 力扣-62-最小路径和
# hot100-动态规划


from typing import List


class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        dp = [[float('inf') for _ in range(n)] for _ in range(m)]
        dp[0][0] = grid[0][0]

        for i in range(m):
            for j in range(n):
                dp[i][j] = min(dp[i][j], dp[i-1][j] + grid[i][j], dp[i][j-1] + grid[i][j])
        return dp[-1][-1]


if __name__ == '__main__':
    grid = [[int(i) for i in line.split(",")] for line in input().split()]
    print(Solution().minPathSum(grid))
