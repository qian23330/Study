# 力扣-35-搜索插入位置
# hot100-数组-二分查找


from typing import List


class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        left, right = 0, len(nums) - 1

        while left <= right:
            mid = (left + right) // 2

            if nums[mid] < target:
                left = mid + 1
            elif nums[mid] > target:
                right = mid - 1
            else:
                return mid
        return left


if __name__ == '__main__':
    tar = int(input())
    number = [int(i) for i in input().split()]
    print(Solution().searchInsert(number, tar))
