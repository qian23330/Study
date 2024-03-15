### 力扣-69-x的平方根 ###
# 数组-二分查找

class Solution:
    @staticmethod
    def mySqrt(x: int) -> int:
        left, right = 0, x  # 考虑0和1的情况，不减一

        while left <= right:
            mid = left + (right - left) // 2
            mid_squared = mid * mid

            if mid_squared == x:
                return mid
            elif mid_squared < x:
                left = mid + 1
            else:
                right = mid - 1

        # 当无法找到精确的整数平方根时，返回最接近的整数
        return right


if __name__ == '__main__':
    n = int(input())
    print(Solution.mySqrt(n))

