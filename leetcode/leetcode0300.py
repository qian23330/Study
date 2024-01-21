# 力扣-300-最长递增子序列
# 动态规划


from typing import List


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        if len(nums) <= 1:
            return len(nums)
        dp = [1] * len(nums)
        result = 1
        for i in range(1, len(nums)):
            for j in range(0, i):
                if nums[i] > nums[j]:
                    dp[i] = max(dp[i], dp[j] + 1)
            result = max(result, dp[i])  # 取长的子序列
        return result


if __name__ == '__main__':
    nums = [int(i) for i in input().split()]
    print(Solution().lengthOfLIS(nums))
