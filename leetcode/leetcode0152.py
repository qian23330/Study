# 力扣-152-乘积最大子数组
# hot100-动态规划


class Solution:
    def maxProduct(self, nums):
        maxF = nums.copy()  # 构造最大值数组，用来记录以当前位置为结束点的子数组的最大连续乘积
        minF = nums.copy()  # 构造最小值数组，用来记录以当前位置为结束点的子数组的最小连续乘积
        for i in range(1, len(nums)):
            maxF[i] = max(maxF[i - 1] * nums[i], max(nums[i], minF[i - 1] * nums[i]))
            minF[i] = min(minF[i - 1] * nums[i], min(nums[i], maxF[i - 1] * nums[i]))
        return max(maxF)  # 返回最大连续乘积数组中的最大值


if __name__ == '__main__':
    nums = [int(i) for i in input().split()]
    print(Solution().maxProduct(nums))
