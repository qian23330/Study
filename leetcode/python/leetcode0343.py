### 力扣-343-整数拆分 ###
# 动态规划


class Solution:

    # 假设对正整数 i 拆分出的第一个正整数是 j（1 <= j < i），则有以下两种方案：
    # 1) 将 i 拆分成 j 和 i−j 的和，且 i−j 不再拆分成多个正整数，此时的乘积是 j * (i-j)
    # 2) 将 i 拆分成 j 和 i−j 的和，且 i−j 继续拆分成多个正整数，此时的乘积是 j * dp[i-j]
    def integerBreak(self, n):
        dp = [0] * (n + 1)  # 创建一个大小为n+1的数组来存储计算结果
        dp[2] = 1  # 初始化dp[2]为1，因为当n=2时，只有一个切割方式1+1=2，乘积为1

        # 从3开始计算，直到n
        for i in range(3, n + 1):
            # 遍历所有可能的切割点
            for j in range(1, i // 2 + 1):
                # 计算切割点j和剩余部分(i-j)的乘积，并与之前的结果进行比较取较大值

                dp[i] = max(dp[i], (i - j) * j, dp[i - j] * j)

        return dp[n]  # 返回最终的计算结果


if __name__ == '__main__':
    n = int(input())
    print(Solution().integerBreak(n))
