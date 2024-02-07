# 力扣-LCR070-有序数组中的单一元素
# 二分查找-位运算


from typing import List


class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        low, high = 0, len(nums) - 1
        while low < high:
            mid = (low + high) >> 1
            if nums[mid] == nums[mid ^ 1]:
                low = mid + 1
            else:
                high = mid
        return nums[low]


if __name__ == '__main__':
    nums = [int(i) for i in input().split()]
    print(Solution().singleNonDuplicate(nums))
