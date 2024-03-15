# 力扣-238-除自身以外数组的乘积
# hot100-数组


from typing import List


class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        length = len(nums)
        # L 和 R 分别表示左右两侧的乘积列表
        L, R, answer = [0] * length, [0] * length, [0] * length
        L[0] = 1
        for i in range(1, length):
            L[i] = nums[i - 1] * L[i - 1]
        R[length - 1] = 1
        for i in reversed(range(length - 1)):
            R[i] = nums[i + 1] * R[i + 1]
        for i in range(length):
            answer[i] = L[i] * R[i]

        return answer


if __name__ == '__main__':
    nums = [int(i) for i in input().split()]
    print(Solution().productExceptSelf(nums))
