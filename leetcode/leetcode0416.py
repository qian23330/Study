### 力扣-416-分割等和子集 ###
# 动态规划-01背包问题


from typing import List


class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        if sum(nums) % 2 != 0:
            return False
        target = sum(nums) // 2
        dp = [0] * (target + 1)
        for num in nums:
            for j in range(target, num-1, -1):
                dp[j] = max(dp[j], dp[j-num] + num)
        return dp[-1] == target


if __name__ == '__main__':
    nums = list(map(int, input().split()))
    print(Solution().canPartition(nums))
    