# 力扣-153-寻找旋转排序数组中的最小值
# hot100-数组-二分查找


from typing import List


class Solution:
    def findMin(self, nums: List[int]) -> int:
        low, high = 0, len(nums) - 1

        while low < high:  # 左闭右开
            mid = (low + high) >> 1
            if nums[mid] < nums[high]:
                high = mid
            else:
                low = mid + 1
        return nums[low]


if __name__ == '__main__':
    nums = [int(i) for i in input().split()]
    print(Solution().findMin(nums))
