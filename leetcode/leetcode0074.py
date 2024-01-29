# 力扣-74-搜索二维矩阵
# hot100-矩阵-二分查找


from typing import List


class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m, n = len(matrix), len(matrix[0])
        left, right = 0, m * n - 1  # 矩阵拉伸为一维数组
        while left <= right:
            mid = (left + right) >> 1
            x, y = mid // n, mid % n
            if matrix[x][y] > target:
                right = mid - 1
            elif matrix[x][y] < target:
                left = mid + 1
            else:
                return True
        return False


if __name__ == '__main__':
    matrix = [[int(i) for i in row.split(",")] for row in input().split()]
    target = int(input())
    print(Solution().searchMatrix(matrix, target))
