### 力扣-11-盛最多水的容器 ###
# 双指针


from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        left, right = 0, len(height) - 1
        water = 0
        while left < right:
            if height[left] < height[right]:
                water = max(water, (right - left) * height[left])
                left += 1
            else:
                water = max(water, (right - left) * height[right])
                right -= 1

        return water


if __name__ == '__main__':
    height = [int(i) for i in input().split()]
    print(Solution().maxArea(height))
