### 力扣-27-移除元素 ###
# 数组-双指针

from typing import List


class Solution:
    @staticmethod
    def removeElement(nums: List[int], val: int) -> int:
        # 快慢指针(双指针)
        fast = 0
        slow = 0
        size = len(nums)

        while fast < size:
            if nums[fast] != val:
                nums[slow] = nums[fast]
                slow += 1
            fast += 1
        return slow


if __name__ == '__main__':
    number = []
    for i in input().split():
        number.append(int(i))
    n = int(input())
    print(Solution.removeElement(number, n))