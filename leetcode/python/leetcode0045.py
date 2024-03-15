# 力扣-45-跳跃游戏 II
# hot100-贪心


from typing import List


class Solution:
    def jump(self, nums: List[int]) -> int:
        n = len(nums)
        maxPos, jump, count = 0, 0, 0
        for i in range(n - 1):
            if i <= maxPos:
                maxPos = max(maxPos, i + nums[i])
                if i == jump:
                    jump = maxPos
                    count += 1
        return count


if __name__ == '__main__':
    nums = [int(x) for x in input().split()]
    print(Solution().jump(nums))
