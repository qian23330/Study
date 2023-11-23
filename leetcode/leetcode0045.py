### 力扣-45-跳跃游戏2 ###
# 贪心


class Solution:
    def jump(self, nums) -> int:
        if len(nums) == 1:  # 如果数组只有一个元素，不需要跳跃，步数为0
            return 0

        i = 0  # 当前位置
        count = 0  # 步数计数器
        cover = 0  # 当前能够覆盖的最远距离

        while i <= cover:  # 当前位置小于等于当前能够覆盖的最远距离时循环
            for i in range(i, cover + 1):  # 遍历从当前位置到当前能够覆盖的最远距离之间的所有位置
                cover = max(nums[i] + i, cover)  # 更新当前能够覆盖的最远距离
                if cover >= len(nums) - 1:  # 如果当前能够覆盖的最远距离达到或超过数组的最后一个位置，直接返回步数+1
                    return count + 1
            count += 1  # 每一轮遍历结束后，步数+1


if __name__ == '__main__':
    nums = list(map(int, input().split()))
    print(Solution().jump(nums))
