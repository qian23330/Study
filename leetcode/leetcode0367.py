### 力扣-367-有效的完全平方数 ###
# 数组-二分查找

class Solution:
    @staticmethod
    def isPerfectSquare(x: int) -> bool:
        left, right = 0, x  # 考虑0和1的情况，不减一

        while left <= right:
            mid = left + (right - left) // 2
            mid_squared = mid * mid

            if mid_squared == x:
                return True
            elif mid_squared < x:
                left = mid + 1
            else:
                right = mid - 1

        return False


if __name__ == '__main__':
    n = int(input())
    print(Solution.isPerfectSquare(n))
