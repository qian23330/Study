# 力扣-75-颜色分类
# 数组


from typing import List


class Solution:
    def sortColors(self, nums: List[int]) -> None:
        n = len(nums)
        ptr = 0
        for i in range(n):
            if nums[i] == 0:
                nums[i], nums[ptr] = nums[ptr], nums[i]
                ptr += 1
        for i in range(ptr, n):
            if nums[i] == 1:
                nums[i], nums[ptr] = nums[ptr], nums[i]
                ptr += 1


if __name__ == '__main__':
    nums = [int(i) for i in input().split()]
    print(Solution().sortColors(nums))
