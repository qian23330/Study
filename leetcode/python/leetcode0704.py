### 力扣-704-二分查找 ###
# 数组-二分查找

class Solution:
    @staticmethod
    def search(nums: list[int], target: int) -> int:
        left, right = 0, len(nums) - 1  # 定义target在左闭右闭的区间里，[left, right]

        while left <= right:
            middle = left + (right - left) // 2

            if nums[middle] > target:
                right = middle - 1  # target在左区间，所以[left, middle - 1]
            elif nums[middle] < target:
                left = middle + 1  # target在右区间，所以[middle + 1, right]
            else:
                return middle  # 数组中找到目标值，直接返回下标
        return -1  # 未找到目标值


if __name__ == '__main__':
    nums = []
    target = int(input())
    for i in input().split():
        nums.append(int(i))

    print(Solution.search(nums, target))
