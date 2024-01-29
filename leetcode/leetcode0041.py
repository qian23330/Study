# 力扣-41-缺失的第一个正数
# hot100-数组-哈希


from typing import List


class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        n = len(nums)
        for i in range(n):
            if nums[i] <= 0:
                nums[i] = n + 1

        for i in range(n):
            num = abs(nums[i])
            if num <= n:
                nums[num - 1] = -abs(nums[num - 1])

        for i in range(n):
            if nums[i] > 0:
                return i + 1

        return n + 1


if __name__ == '__main__':
    nums = [int(i) for i in input().split()]
    print(Solution().firstMissingPositive(nums))
