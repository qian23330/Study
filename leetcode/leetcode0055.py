### 力扣-55-跳跃游戏 ###
# 贪心


from typing import List


class Solution:
    def canJump(self, nums: List[int]) -> bool:
        cover = 0
        if len(nums) == 1: return True
        i = 0
        # python不支持动态修改for循环中变量,使用while循环代替
        while i <= cover:
            cover = max(i + nums[i], cover)
            if cover >= len(nums) - 1: return True
            i += 1
        return False


if __name__ == '__main__':
    nums = list(map(int, input().split()))
    print(Solution().canJump(nums))
