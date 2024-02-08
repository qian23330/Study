# 力扣-LCR068-搜索插入位置
# 二分查找


from typing import List


class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1
        while left <= right:
            mid = (left + right) >> 1
            if nums[mid] >= target:
                right = mid - 1
            else:
                left = mid + 1
        return left


if __name__ == '__main__':
    nums = [int(i) for i in input().split()]
    target = int(input())
    print(Solution().searchInsert(nums, target))
