### 力扣-1035-不相交的线 ###
# 动态规划-和1143一样


from typing import List


class Solution:
    def maxUncrossedLines(self, A: List[int], B: List[int]) -> int:
        dp = [[0] * (len(B)+1) for _ in range(len(A)+1)]
        for i in range(1, len(A)+1):
            for j in range(1, len(B)+1):
                if A[i-1] == B[j-1]:
                    dp[i][j] = dp[i-1][j-1] + 1
                else:
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1])
        return dp[-1][-1]


if __name__ == '__main__':
    A = [int(i) for i in input().split()]
    B = [int(i) for i in input().split()]
    print(Solution().maxUncrossedLines(A, B))
