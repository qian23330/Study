### 力扣-42-接雨水 ###
# 双指针


from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        left, right = 0, len(height) - 1
        left_max, right_max = 0, 0
        rain = 0

        while left < right:
            left_max = max(left_max, height[left])
            right_max = max(right_max, height[right])
            if height[left] < height[right]:
                rain += left_max - height[left]
                left += 1
            else:
                rain += right_max - height[right]
                right -= 1

        return rain


if __name__ == '__main__':
    height = [int(i) for i in input().split()]
    print(Solution().trap(height))
