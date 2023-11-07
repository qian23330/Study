### 力扣-35-搜索插入位置 ###
# 数组-二分查找

class Solution:
    @staticmethod
    def searchInsert(nums: list[int], target: int) -> int:
        left, right = 0, len(nums) - 1

        while left <= right:
            mid = (left + right) // 2

            if nums[mid] < target:
                left = mid + 1
            elif nums[mid] > target:
                right = mid - 1
            else:
                return mid
        return right + 1


if __name__ == '__main__':
    tar = int(input())
    number = []
    for i in input().split():
        number.append(int(i))
    print(Solution.searchInsert(number, tar))