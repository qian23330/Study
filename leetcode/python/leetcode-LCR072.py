# 力扣-LCR072-x 的平方根
# 二分查找


class Solution:
    def mySqrt(self, x: int) -> int:
        left, right = 0, x
        result = -1
        while left <= right:
            sqrt = (left + right) >> 1
            if sqrt * sqrt <= x:
                result = sqrt
                left = sqrt + 1
            else:
                right = sqrt - 1
        return result


if __name__ == '__main__':
    x = int(input())
    print(Solution().mySqrt(x))
