# 力扣-118-杨辉三角
# 动态规划


class Solution:
    def generate(self, numRows):
        # 初始化动态规划数组
        dp = [[0 for _ in range(i + 1)] for i in range(numRows)]

        # 遍历每一行
        for i in range(numRows):
            # 每一行的第一个和最后一个元素总是 1
            dp[i][0] = dp[i][i] = 1

            # 计算中间元素
            for j in range(1, i):
                # 中间元素等于上一行的相邻两个元素之和
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]

        # 返回结果列表
        return dp


if __name__ == '__main__':
    numRows = int(input())
    print(Solution().generate(numRows))
