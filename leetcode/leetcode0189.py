### 力扣-189-轮转数组 ###
# 数组-滑动窗口


from typing import List


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k %= len(nums)
        nums[:] = nums[-k:] + nums[:-k]


if __name__ == '__main__':
    nums = [int(i) for i in input().split()]
    k = int(input())
    print(Solution().rotate(nums, k))
