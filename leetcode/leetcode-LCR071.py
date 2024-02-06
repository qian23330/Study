# 力扣-LCR071-按权重随机选择
# 二分查找-前缀和


import random
from bisect import bisect_left
from itertools import accumulate
from typing import List


class Solution:

    def __init__(self, w: List[int]):
        self.pre = list(accumulate(w))
        self.total = sum(w)

    def pickIndex(self) -> int:
        x = random.randint(1, self.total)
        return bisect_left(self.pre, x)

    # 查找原理
    # def bisect_left(self, pre, x):
    #     left, right = 0, len(pre) - 1
    #     while left <= right:
    #         mid = (left + right) >> 1
    #         if pre[mid] < x:
    #             left = mid + 1
    #         else:
    #             right = mid + 1
    #     return left


if __name__ == '__main__':
    w = [int(i) for i in input().split()]
    print(Solution(w).pickIndex())
