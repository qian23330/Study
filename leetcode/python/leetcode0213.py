### 力扣-213-打家劫舍II ###
# 动态规划


from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) < 3:
            return max(nums)

        # 情况二：不抢劫最后一个房屋
        result1 = self.robRange(nums[:-1])

        # 情况三：不抢劫第一个房屋
        result2 = self.robRange(nums[1:])

        return max(result1, result2)

    def robRange(self, nums):
        dp = [[0, 0] for _ in range(len(nums))]
        dp[0][1] = nums[0]

        for i in range(1, len(nums)):
            dp[i][0] = max(dp[i - 1])
            dp[i][1] = dp[i - 1][0] + nums[i]

        return max(dp[-1])


if __name__ == '__main__':
    nums = [int(i) for i in input().split()]
    print(Solution().robRange(nums))
