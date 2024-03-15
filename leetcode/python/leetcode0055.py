# 力扣-55-跳跃游戏
# hot100-贪心


from typing import List


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        n, rightmost = len(nums), 0
        for i in range(n):
            if i <= rightmost:
                rightmost = max(rightmost, i + nums[i])
                if rightmost >= n - 1:
                    return True
        return False


if __name__ == '__main__':
    nums = [int(x) for x in input().split()]
    print(Solution().canJump(nums))
