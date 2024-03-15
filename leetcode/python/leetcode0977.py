### 力扣-977-有序数组的平方 ###
# 数组-双指针

class Solution:
    @staticmethod
    def sortedSquares(nums: list[int]) -> list[int]:

        for i in range(len(nums)):
            nums[i] = nums[i] ** 2

        nums.sort()

        return nums

# 双指针解法
# class Solution:
#     def sortedSquares(self, nums: List[int]) -> List[int]:
#         n = len(nums)
#         ans = [0] * n
#
#         i, j, pos = 0, n - 1, n - 1
#         while i <= j:
#             if nums[i] * nums[i] > nums[j] * nums[j]:
#                 ans[pos] = nums[i] * nums[i]
#                 i += 1
#             else:
#                 ans[pos] = nums[j] * nums[j]
#                 j -= 1
#             pos -= 1
#
#         return ans


if __name__ == '__main__':
    numbers = []
    for i in input().split():
        numbers.append(int(i))

    print(Solution.sortedSquares(numbers))
