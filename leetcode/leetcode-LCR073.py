# 力扣-LCR073-爱吃香蕉的狒狒
# 二分查找


from typing import List


class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        left, right = 1, max(piles)
        while left < right:
            speed = (right + left) >> 1
            if sum([(speed + p - 1) // speed for p in piles]) <= h:
                right = speed
            else:
                left = speed + 1
        return left


if __name__ == '__main__':
    piles = [int(i) for i in input().split()]
    h = int(input())
    print(Solution().minEatingSpeed(piles, h))

