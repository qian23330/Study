### 力扣-674-最长连续递增序列 ###
# 动态规划


from typing import List


class Solution:
    def findLengthOfLCIS(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        result = 1
        dp = [1] * len(nums)
        for i in range(len(nums) - 1):
            if nums[i+1] > nums[i]:  # 连续记录
                dp[i+1] = dp[i] + 1
            result = max(result, dp[i+1])
        return result


if __name__ == '__main__':
    nums = [int(i) for i in input().split()]
    print(Solution().findLengthOfLCIS(nums))
