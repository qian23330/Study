### 力扣-509-斐波那契数 ###
# 动态规划


class Solution:
    def fib(self, n: int) -> int:

        # 排除 Corner Case
        if n == 0:
            return 0

        # 创建 dp table
        dp = [0] * (n + 1)

        # 初始化 dp 数组
        dp[0] = 0
        dp[1] = 1

        # 遍历顺序: 由前向后。因为后面要用到前面的状态
        for i in range(2, n + 1):
            # 确定递归公式/状态转移公式
            dp[i] = dp[i - 1] + dp[i - 2]

        # 返回答案
        return dp[n]


if __name__ == '__main__':
    n = int(input())
    print(Solution().fib(n))
