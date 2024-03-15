### 力扣-377-组合总和 Ⅳ ###
# 动态规划-完全背包问题


from typing import List


class Solution:
    def combinationSum4(self, nums: List[int], target: int) -> int:
        dp = [0] * (target + 1)  # 创建动态规划数组，用于存储组合总数
        dp[0] = 1  # 初始化背包容量为0时的组合总数为1

        for i in range(1, target + 1):  # 遍历背包容量
            for j in nums:  # 遍历物品列表
                if i >= j:  # 当背包容量大于等于当前物品重量时
                    dp[i] += dp[i - j]  # 更新组合总数

        return dp[-1]  # 返回背包容量为target时的组合总数


if __name__ == '__main__':
    nums = [int(x) for x in input().split()]
    target = int(input())
    print(Solution().combinationSum4(nums, target))
